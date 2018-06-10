package com.bigdata.szb.repository;

import com.bigdata.szb.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: AdRepository
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Repository
public interface AdRepository extends JpaRepository<Ad,Long>{
}
