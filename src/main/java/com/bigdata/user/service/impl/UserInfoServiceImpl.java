package com.bigdata.user.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.MD5Utils;
import com.bigdata.framework.sends.TxMsgUtil;
import com.bigdata.user.model.UserInfo;
import com.bigdata.user.repository.UserInfoRepository;
import com.bigdata.user.service.UserInfoService;
import com.bigdata.user.vo.MsgVo;
import com.github.qcloudsms.SmsSenderUtil;
import com.github.qcloudsms.SmsSingleSenderResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @ClassName: UserInfoServiceImpl
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Value("${tx.templateId}")
    private String templateId;

    @Value("${tx.appId}")
    private String appId;
    @Value("${tx.appKey}")
    private String  appKey;

    public UserInfo findByUsername(UserInfo userinfo) throws SZBException{
        UserInfo userInfo2 =userInfoRepository.findByLoginName(userinfo.getLoginName());
        userinfo.setPassword(MD5Utils.getSaltMD5(userinfo.getPassword(),userInfo2.getSalt()));
        //Example<UserInfo> example = Example.of(userinfo);
        return null;//userInfoRepository.findOne(example).orElseThrow(()->new SZBException("账号或密码错误！！"));
    }

    public UserInfo saveUser(UserInfo userinfo) throws  SZBException{
        return null;//userInfoRepository.c(userinfo);
    }

    @Override
    public MsgVo sendMsg(String phone) throws SZBException {
        long random = Math.abs(SmsSenderUtil.getRandom());
        MsgVo vo = new MsgVo();
        String[] msgs ={random+"","5"};
        SmsSingleSenderResult result =TxMsgUtil.getTxMsgUtil().sendMsgByTemp(Integer.parseInt(appId),appKey,phone,Integer.parseInt(templateId),msgs);
        if (result.getResponse().statusCode==200){
            vo.setMsg("短信发送成功，请耐心等待");
            vo.setCode(random);
            return vo;
        }else{
            vo.setMsg(result.getResponse().body);
            return vo;
        }


    }

    @Override
    public boolean findById(Long id) throws SZBException {
        return false ;//userInfoRepository.existsById(id);
    }

    @Override
    public UserInfo forgetPassword(UserInfo userinfo) throws SZBException {
        UserInfo userInfo2 =userInfoRepository.findByLoginName(userinfo.getLoginName());
        if (userInfo2 ==null)
            return null;
        if (!userInfo2.getPhone().equals(userinfo.getPhone()))
            return null;
        userInfo2.setPassword(MD5Utils.getSaltMD5(userinfo.getPassword(),userInfo2.getSalt()));
        //userInfoRepository.save(userInfo2);
        return userInfo2;
    }
}
