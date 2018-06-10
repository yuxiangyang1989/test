package com.bigdata.user.repository;

import com.bigdata.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: UserInfoRepository
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{

    UserInfo findByLoginName(String loginName);
}
