package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.AppList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yang
 * @ClassName: AppListRepository
 * @Description: 精品推荐持久层
 * @date 2018-05-22
 * @version:1.0.0
 */
@Mapper
public interface AppListRepository  extends IBaseRepository<AppList, String> {
    List<AppList>  findAll();
}
