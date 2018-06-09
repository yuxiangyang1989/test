package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.AppList;

import java.util.List;

/**
 * @author yang
 * @ClassName: AppListService
 * @Description: 查看精品推荐
 * @date 2018-05-27
 * @version:
 */
public interface AppListService {

    /**
     * 查询所有精品推荐
     * @return List<AppListVo>
     */
    public List<AppList> findAppAll() throws SZBException;
}
