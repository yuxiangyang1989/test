package com.bigdata.user.service;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.UserInfo;
import com.bigdata.user.vo.MsgVo;

/**
 * @author yang
 * @ClassName: UserInfoService
 * @Description:用户信息服务
 * @date 2018-05-30
 * @version:1.0.0
 */
public interface UserInfoService {
    /**
     * 登录
     * @param userinfo
     * @return
     * @throws SZBException
     */
    public UserInfo findByUsername(UserInfo userinfo) throws SZBException;

    /**
     * 注册更新信息
     * @param userinfo
     * @return
     * @throws SZBException
     */
    public UserInfo saveUser(UserInfo userinfo) throws SZBException;

    /**
     * 发送短息
     * @param phone
     * @return
     * @throws SZBException
     */
    public MsgVo sendMsg(String phone) throws SZBException;

    /**
     * 验证是否存在
     * @param id
     * @return
     * @throws SZBException
     */
    public boolean findById(Long id) throws SZBException;

    public UserInfo forgetPassword(UserInfo userinfo) throws SZBException;
}
