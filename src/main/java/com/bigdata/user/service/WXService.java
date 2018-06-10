package com.bigdata.user.service;

import com.bigdata.exception.SZBException;
import com.bigdata.user.vo.WXTokenVo;
import com.bigdata.user.vo.WXUserInfoVo;

/**
 * @author yang
 * @ClassName: WXService
 * @Description:微信授权
 * @date 2018-06-09
 * @version:1.0.0
 */
public interface WXService {
    /**
     * 授权获取code
     * @return
     * @throws SZBException
     */
    public String getCode() throws SZBException;

    /**
     * 获取wxtoken
     * @param code
     * @return
     * @throws SZBException
     */
    public WXTokenVo getAccessToken(String code) throws SZBException;

    /**
     * 刷新token
     * @param refresh_token
     * @return
     * @throws SZBException
     */
    public WXTokenVo refreshToken(String refresh_token) throws SZBException;

    /**
     * 拉取用户信息
     * @param access_token
     * @param openid
     * @return
     * @throws SZBException
     */
    public WXUserInfoVo getUserInfo(String access_token, String openid) throws SZBException;
}
