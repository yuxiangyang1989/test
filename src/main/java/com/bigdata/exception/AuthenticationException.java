package com.bigdata.exception;

import com.bigdata.enums.ResponseCode;

/**
 * @author yang
 * @ClassName: AuthenticationException
 * @Description:
 * @date 2018-06-05
 * @version:
 */
public class AuthenticationException extends SZBException  {
    public AuthenticationException(ResponseCode responseCode) {
        super(responseCode);
    }

    public AuthenticationException(ResponseCode responseCode, Object... objects) {
        super(responseCode, objects);
    }

    public AuthenticationException(String msg) {
        super(msg);
    }

    public AuthenticationException(String msg, Throwable ex) {
        super(msg, ex);
    }
}

