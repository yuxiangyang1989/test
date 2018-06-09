package com.bigdata.exception;

import com.bigdata.enums.ResponseCode;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yang
 * @ClassName: SZBException
 * @Description:收账宝异常
 * @date 2018-05-27
 * @version:
 */
public class SZBException extends RuntimeException{

    private ResponseCode responseCode;
    private String message;
    public SZBException(Throwable cause) {
        super(cause);
    }

    public SZBException() {
        super();
    }

    public SZBException(String message) {
        super(message);
    }

    public SZBException(String message, Throwable cause) {
        super(message, cause);
    }

    public SZBException(final ResponseCode responseCode) {
        super(String.valueOf(responseCode.code()));
        this.responseCode = responseCode;
        this.message = responseCode.desc();
    }

    public SZBException(final ResponseCode responseCode, Object... objects) {
        super(String.valueOf(responseCode.code()));
        this.responseCode = responseCode;
        message = ArrayUtils.isEmpty(objects) || StringUtils.isBlank(responseCode.template())
                ? responseCode.desc()
                : String.format(this.responseCode.template(), objects);
    }
}
