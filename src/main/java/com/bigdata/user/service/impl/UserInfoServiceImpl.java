package com.bigdata.user.service.impl;

import com.bigdata.enums.ResponseCode;
import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.MD5Utils;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.user.model.UserInfo;
import com.bigdata.user.repository.UserInfoRepository;
import com.bigdata.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public UserInfo findByUsername(UserInfo userinfo) throws SZBException{
        UserInfo userInfo2 =userInfoRepository.findByLoginName(userinfo.getLoginName());
        userinfo.setPassword(MD5Utils.getSaltMD5(userinfo.getPassword(),userInfo2.getSalt()));
        Example<UserInfo> example = Example.of(userinfo);
        return userInfoRepository.findOne(example).orElseThrow(()->new SZBException("账号或密码错误！！"));
    }

    public UserInfo saveUser(UserInfo userinfo) throws  SZBException{
        return userInfoRepository.save(userinfo);
    }
}
