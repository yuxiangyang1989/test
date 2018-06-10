package com.bigdata.enums.qqhb;

import lombok.Getter;

import java.util.Objects;

/**
 * @author yang
 * @ClassName: VipEnum
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Getter
public enum VipEnum {

    Open(1,"开通"),
    CLOSE(0,"未开通");

    VipEnum(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;


    public static VipEnum fromValue(Integer value) {
        for (VipEnum statusEnum : VipEnum.values()) {
            if (Objects.equals(value, statusEnum.getCode())) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
