package com.bigdata.user.repository;

import com.bigdata.user.model.WXToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: WXTokenRepository
 * @Description:
 * @date 2018-06-09
 * @version:1.0.0
 */
@Repository
public interface WXTokenRepository extends JpaRepository<WXToken,Long>{
}
