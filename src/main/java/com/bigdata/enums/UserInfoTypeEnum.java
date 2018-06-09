package com.bigdata.enums;

/**
 * @author yang
 * @enumName: UserInfoType
 * @Description:
 * @date 2018-05-30
 * @version:
 */
public enum UserInfoTypeEnum {
    NORMAL(1,"账户正常"),
    FREEZE(2,"账户冻结"),
    LOGOUT(3,"账户注销");

    UserInfoTypeEnum(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;
}
