package com.bigdata.enums;

/**
 * @author yang
 * @enumName: ResponseCodeType
 * @Description:
 * @date 2018-05-29
 * @version:
 */
public enum ResponseCodeType {
    None(0, "无"),
    common(9, "通用"),
    Permission(922, "权限"),;

    private final int code;
    private final String desc;
    private final ResponseCodeType parent;

    ResponseCodeType(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.parent = null;
    }
    ResponseCodeType(ResponseCodeType parent, int code, String desc) {
        this.parent = parent;
        this.code = code;
        this.desc = desc;

    }
    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }
}
