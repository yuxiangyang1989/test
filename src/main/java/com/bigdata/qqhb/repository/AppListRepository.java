package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.AppList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: AppListRepository
 * @Description: 精品推荐持久层
 * @date 2018-05-22
 * @version:1.0.0
 */
public interface AppListRepository  extends JpaRepository<AppList, String> {
}
