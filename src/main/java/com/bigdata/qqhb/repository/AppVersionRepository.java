package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: AppVersionRepository
 * @Description: app版本控制
 * @date 2018-05-24
 * @version:
 */
@Repository
public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {
}
