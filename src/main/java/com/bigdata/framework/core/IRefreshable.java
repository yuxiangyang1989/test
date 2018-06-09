package com.bigdata.framework.core;


import com.bigdata.framework.common.utils.HostUtils;

/**
 * @author yang
 * @ClassName: IRefreshable
 * @Description:
 * @date 2018-06-05
 * @version:
 */
public interface IRefreshable {
    String LOCAL_HOST = HostUtils.getLocalIp();

    /**
     * 获取刷新类型
     *
     * @return 订阅时刷新的名字
     */
    String getRefreshChannel();

    /**
     * 刷新缓存
     */
    void refresh();
}
