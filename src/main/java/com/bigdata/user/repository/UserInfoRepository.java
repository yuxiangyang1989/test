package com.bigdata.user.repository;

import com.bigdata.user.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: UserInfoRepository
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Mapper
public interface UserInfoRepository {

    UserInfo findByLoginName(String loginName);
}
