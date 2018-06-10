package com.bigdata.user.repository;

import com.bigdata.user.model.WXUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: WXUserInfoRepository
 * @Description:
 * @date 2018-06-09
 * @version:1.0.0
 */
@Repository
public interface WXUserInfoRepository extends JpaRepository<WXUserInfo,Long>{
    WXUserInfo findByOpenid(String openid);
}
