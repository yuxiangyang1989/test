package com.bigdata.enums.qqhb;

import lombok.Getter;

import java.util.Objects;

/**
 * @author yang
 * @enumName: VipTypeEnum
 * @Description:会员等级
 * @date 2018-06-09
 * @version:1.0.0
 */
@Getter
public enum VipTypeEnum {

    PROBATION(0,"试用期会员"),
    MONTHLY_CARD(1,"月卡会员"),
    QUARTERLY_CARD(2,"季卡会员"),
    YEAR_CARD(3,"年卡会员");

    VipTypeEnum(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;

    public static VipTypeEnum fromValue(Integer value) {
        for (VipTypeEnum statusEnum : VipTypeEnum.values()) {
            if (Objects.equals(value, statusEnum.getCode())) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
