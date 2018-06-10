package com.bigdata.enums.szb;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

/**
 * @author yang
 * @enumName: StatementType
 * @Description:账单类型
 * @date 2018-05-29
 * @version:1.0.0
 */
@Getter
public enum StatementType {

    EXPENDITURE(1,"支出"),
    INCOME(2,"收入");

    StatementType(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;

    //获取枚举实例
    public static StatementType fromValue(Integer value) {
        for (StatementType statusEnum : StatementType.values()) {
            if (Objects.equals(value, statusEnum.getCode())) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException();
    }

}
