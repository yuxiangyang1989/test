package com.bigdata.framework.web.util;

import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String getContent(Map<String, String> params, String content) {
        String reg = "\\{\\w*}";//
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String group = matcher.group();//
            String key = group.substring(1, group.length() - 1);
            if (!params.containsKey(key))
                throw new SZBException("未找到需要替换的key：" + key);
            content = content.replace(group, params.get(key));
        }
        return content;
    }

}
