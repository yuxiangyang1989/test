package com.bigdata.framework.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * @author yang
 * @ClassName: HostUtils
 * @Description:
 * @date 2018-06-05
 * @version:
 */
@Slf4j
public class HostUtils {
    /**
     * 获取本机 IP.
     *
     * @return 本机IP, 如果异常则返回 null
     */
    public static String getLocalIp() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (Exception ex) {
            log.error("Can not get ip of local machine", ex);
            return null;
        }
    }
}
