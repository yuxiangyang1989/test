package com.bigdata.abs;

import com.bigdata.constant.Constants;
import com.bigdata.enums.ResponseCode;
import com.bigdata.exception.AuthenticationException;
import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.framework.web.util.HostUtils;
import com.bigdata.user.vo.SimpleUser;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: AbstractController
 * @Description:
 * @date 2018-06-05
 * @version:
 */
@Slf4j
@RestController
public class AbstractController {
   /* private final Splitter API_VER_SPLITTER = Splitter.on('.').trimResults().omitEmptyStrings();

    @Autowired
    protected HttpServletRequest httpRequest;
    @Autowired
   // protected IUserFeign userProvider;

    protected SimpleUser getUserByToken() throws AuthenticationException {
        HttpServletRequest request = Optional.ofNullable(httpRequest).orElse(getRequest());
        if (null == request) {
            throw new SZBException(ResponseCode.PermissionDenied);
        }
        String token = request.getHeader(Constants.TOKEN_PARA_NAME);
        if (StringUtils.isBlank(token)) {
            throw new AuthenticationException(ResponseCode.TokenInvalid);
        }
       // SimpleUser simpleUser = userProvider.getByToken(token);
        if (null == simpleUser || (simpleUser.getId() != null && NumberUtils.isNotPositive(simpleUser.getId()))) {
            throw new AuthenticationException(ResponseCode.TokenInvalid);
        }

        return simpleUser;
    }

    *//**
     * @return HttpServletRequest
     *//*
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public SimpleUser getUserByToken(@PathVariable("token") String token) {
        if (StringUtils.isNotBlank(token)) {
            try {
                //优先从redis中获取数据
                SimpleUser simpleUser = redisService.getSimpleUserByToken(token);
                if (simpleUser != null) {
                    return simpleUser;
                }
                log.info("getUserByToken get simpleUser from origin logic, token: {} ", token);

                SimpleUser user = Optional.ofNullable(securityService.getUserByToken(token, getRequestHost()))
                        .filter(NumberUtils::isPositive).map(userService::getSimpleUser).orElse(null);
                //TODO 需要修改为取缓存中的数据
                if (null != user.getEmployeeType()) {
                    Optional.ofNullable(taipingService.findByUserId(user.getId())).ifPresent(userAuthTaiping -> user.setTaiPingUserName(userAuthTaiping.getUserName()));
                }
                if (null != user) {
                    user.setToken(token);
                }
                return user;
            } catch (Exception ex) {
                log.error("{} by token:{} on host:{}", ex.getMessage(), token, getRequestHost());
            }
        }
        return null;
    }

    *//**
     * 根据请求获取IP
     *
     * @return 请求IP
     *//*
    protected String getRequestHost() {
        return getRequestHost(getRequest());
    }

    *//**
     * 根据请求获取IP
     *
     * @param request HttpServletRequest
     * @return 请求IP
     *//*
    protected String getRequestHost(HttpServletRequest request) {
        request = Optional.ofNullable(request).orElse(httpRequest);
        return null == request ? StringUtils.EMPTY : HostUtils.getRequestIp(request);
    }*/
}
