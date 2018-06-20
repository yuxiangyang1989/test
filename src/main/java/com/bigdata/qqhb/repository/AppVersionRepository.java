package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.AppVersion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yang
 * @ClassName: AppVersionRepository
 * @Description: app版本控制
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface AppVersionRepository extends IBaseRepository<AppVersion, Long> {
    List<AppVersion> findAll();
}
