package com.bigdata.user.repository;

import com.bigdata.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: UserInfoRepository
 * @Description:
 * @date 2018-06-03
 * @version:
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{

    UserInfo findByLoginName(String loginName);
}
