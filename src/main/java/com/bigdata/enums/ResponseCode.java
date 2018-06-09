package com.bigdata.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @enumName: RetCodeEnum
 * @Description:
 * @date 2018-05-27
 * @version:
 */
@Getter
public enum ResponseCode {
    SUCCESS(ResponseCodeType.None,200,"请求成功"),
    GET_DATA_FAIL(ResponseCodeType.None,400,"暂无数据"),
    POST_DATA_FAIL(ResponseCodeType.None,401,"传入参数错误"),
    LOGIN_ERROR(ResponseCodeType.None,402,"账号或密码错误"),
    LOGIC_FAIL(ResponseCodeType.None,500,"内部服务错误,请联系管理员"),
    PermissionDenied(ResponseCodeType.Permission, 500, "无权查询数据，请联系管理"),
    TokenInvalid(ResponseCodeType.Permission, 999, "令牌无效", "令牌(%s)无效"),
    ;

    private final int code;
    private final String desc;
    private final String template;
    private final ResponseCodeType type;



    ResponseCode(ResponseCodeType type, int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.type = type;
        this.template = "";
    }
    ResponseCode(ResponseCodeType type, int code, String desc, String template) {
        this.code = code;
        this.desc = desc;
        this.type = type;
        this.template = template;
    }

    public int code() {
        return this.type.code() * 1000 + this.code;
    }

    public String desc() {
        return this.desc;
    }

    public String template() {
        return this.template;
    }

    private final static Map<Integer, ResponseCode> codeMap = Arrays.stream(ResponseCode.values()).collect(Collectors.toMap(ResponseCode::code, code -> code));
    /**
     * @param code 代码
     * @return 转换出来的状态码
     */
    public static ResponseCode parse(Integer code) {
        return codeMap.get(code);
    }



}
