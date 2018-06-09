package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.AppUpdate;
import com.bigdata.qqhb.model.AppVersion;

/**
 * @author yang
 * @ClassName: AppVersionService
 * @Description: 版本更新
 * @date 2018-05-27
 * @version:
 */
public interface AppVersionService {

    /**
     * 获取当前app版本
     * @return AppVersionVo
     * @throws Exception
     */
    public AppVersion getAppVersion() throws SZBException;
    /**
     * 增加版本更新人
     * @param appUpdateVo
     * @return boolean
     * @throws Exception
     */
    public boolean addVersionInfo(AppUpdate appUpdateVo) throws SZBException;
}
