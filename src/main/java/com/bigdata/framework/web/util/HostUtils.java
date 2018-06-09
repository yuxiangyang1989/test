package com.bigdata.framework.web.util;

import com.bigdata.framework.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yang
 * @ClassName: HostUtils
 * @Description:
 * @date 2018-06-05
 * @version:
 */
@Slf4j
public class HostUtils extends com.bigdata.framework.common.utils.HostUtils {

    /**
     * 获取客户端IP.
     *
     * @param request HTTP Request
     * @return 客户端IP
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip)) {
                ip = getLocalIp();
            }
        }

        if (StringUtils.isNotBlank(ip) && ip.length() > 15 && ip.indexOf(',') > -1) {
            ip = ip.substring(0, ip.indexOf(','));
        }

        return ip;
    }
}
