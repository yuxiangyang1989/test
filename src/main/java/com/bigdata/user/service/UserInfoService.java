package com.bigdata.user.service;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.UserInfo;

/**
 * @author yang
 * @ClassName: UserInfoService
 * @Description:用户信息服务
 * @date 2018-05-30
 * @version:1.0.0
 */
public interface UserInfoService {
    public UserInfo findByUsername(UserInfo userinfo) throws SZBException;

    public UserInfo saveUser(UserInfo userinfo) throws SZBException;
}
