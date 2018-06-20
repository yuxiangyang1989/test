package com.bigdata.szb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.szb.model.Ad;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yang
 * @ClassName: AdRepository
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Mapper
public interface AdRepository extends IBaseRepository<Ad,Long> {
    List<Ad> findAll();
}
