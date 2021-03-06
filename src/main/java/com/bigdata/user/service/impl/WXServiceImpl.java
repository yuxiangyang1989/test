package com.bigdata.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bigdata.enums.user.VipTypeEnum;
import com.bigdata.exception.SZBException;
import com.bigdata.framework.web.util.HostUtils;
import com.bigdata.framework.web.util.HttpClientUtils;
import com.bigdata.framework.web.util.URLEncodeUtil;
import com.bigdata.user.model.VipInfoDao;
import com.bigdata.user.model.VipLevel;
import com.bigdata.user.repository.VipLevelRepository;
import com.bigdata.user.repository.WXTokenRepository;
import com.bigdata.user.repository.WXUserInfoRepository;
import com.bigdata.user.service.WXService;
import com.bigdata.user.model.WXToken;
import com.bigdata.user.model.WXUserInfo;
import com.bigdata.user.vo.WXTokenVo;
import com.bigdata.user.vo.WXUserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @ClassName: WXServiceImpl
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Slf4j
@Service
public class WXServiceImpl implements WXService{

    @Autowired
    private WXTokenRepository wxTokenRepository;
    @Autowired
    private WXUserInfoRepository wxUserInfoRepository;
    @Autowired
    private VipLevelRepository vipLevelRepository;

    @Autowired
    private Environment env;

    @Override
    public String getCode() throws SZBException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("redirect_uri", URLEncodeUtil.getURLEncoderString(env.getProperty("wx.constants.weCatRedirectUrl")));
        String url = HostUtils.getContent(map,env.getProperty("wx.code.url"));
        String result = null;
        try {
           result = HttpClientUtils.get(url,"UTF-8");
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public WXTokenVo getAccessToken(String code) throws SZBException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("code", code);
        WXTokenVo wxToken = null;
        String url = HostUtils.getContent(map,env.getProperty("wx.token.url"));
        try {
            String result = HttpClientUtils.get(url,"UTF-8");
            wxToken = JSON.parseObject(result,WXTokenVo.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        wxTokenRepository.create(wxToken.toModel());
        return wxToken;
    }

    @Override
    public WXTokenVo refreshToken(String refresh_token) throws SZBException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("refresh_token", refresh_token);
        WXTokenVo wxToken = null;
        String url = HostUtils.getContent(map,env.getProperty("wx.refresh.url"));
        try {
            String result = HttpClientUtils.get(url,"UTF-8");
            wxToken = JSON.parseObject(result,WXTokenVo.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        wxTokenRepository.create(wxToken.toModel());
        return wxToken;
    }

    @Override
    public WXUserInfoVo getUserInfo(String access_token, String openid) throws SZBException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("access_token", access_token);
        map.put("openid", openid);
        String url = HostUtils.getContent(map,env.getProperty("wx.uerinf.url"));
        WXUserInfoVo wxUserInfoVo = null;
        try {
            String result = HttpClientUtils.get(url,"UTF-8");
            wxUserInfoVo = JSON.parseObject(result,WXUserInfoVo.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        WXUserInfo wxUserInfo = wxUserInfoRepository.findByOpenid(wxUserInfoVo.getOpenid());
        if (null ==wxUserInfoVo){
            wxUserInfoRepository.create(wxUserInfoVo.toModel());
        }else{
            wxUserInfo.setUpdateTime(new Date());
            wxUserInfoRepository.update(wxUserInfo);
        }

        return wxUserInfoVo;
    }

    @Override
    @Transactional
    public void save(WXToken token, WXUserInfo wxUserInfo) throws SZBException {
        wxTokenRepository.create(token);
        VipLevel vipLevel = vipLevelRepository.findByOpenid(wxUserInfo.getOpenid());
        if(null==vipLevel){
            vipLevel = new VipLevel();
            vipLevel.setOpenid(wxUserInfo.getOpenid());
            vipLevel.setVipType(VipTypeEnum.VIP_TRY);
            vipLevelRepository.create(vipLevel);
        }
        WXUserInfo wxUserInfo1 = wxUserInfoRepository.findByOpenid(wxUserInfo.getOpenid());
        if (null ==wxUserInfo1){
            wxUserInfoRepository.create(wxUserInfo);
        }else{
            wxUserInfo1.setUpdateTime(new Date());
            wxUserInfoRepository.update(wxUserInfo1);
        }
    }
    @Override
    public VipInfoDao getVipInfo(String openid){
        VipInfoDao vipInfoDao = new VipInfoDao();
        WXUserInfo wxUserInfo1 = wxUserInfoRepository.findByOpenid(openid);
        if (null == wxUserInfo1)
            return null;
        VipLevel vipLevel = vipLevelRepository.findByOpenid(openid);
        if (null == vipLevel)
            return null;
        vipInfoDao.setWxUserInfo(wxUserInfo1);
        vipInfoDao.setVipLevel(vipLevel);
        return vipInfoDao;
    }
}
