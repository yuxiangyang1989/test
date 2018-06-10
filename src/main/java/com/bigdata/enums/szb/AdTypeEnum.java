package com.bigdata.enums.szb;

import lombok.Getter;

import java.util.Objects;

/**
 * @author yang
 * @enumName: AdTypeEnum
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Getter
public enum AdTypeEnum {
    PSAS(1,"公益广告"),
    COMMERCIAL(2,"商业广告"),
    SHELVES(88,"广告上架"),
    OFFTHESHELF(99,"广告下架");

    AdTypeEnum(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;

    //获取枚举实例
    public static AdTypeEnum fromValue(Integer value) {
        for (AdTypeEnum statusEnum : AdTypeEnum.values()) {
            if (Objects.equals(value, statusEnum.getCode())) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
