package com.bigdata.enums;

import lombok.Getter;

/**
 * @author yang
 * @enumName: RoleTypeEnum
 * @Description:角色
 * @date 2018-06-02
 * @version:1.0.0
 */
@Getter
public enum RoleTypeEnum {

    GENERAL_USER(1,"普通用户"),
    MEMBER_USER(2,"会员用户"),
    VIP_USER(3,"超级会员用户"),
    ANONYMOUS_USER(4,"匿名用户");


    RoleTypeEnum(int code,String desc){
        this.code =code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;

}
