package com.bigdata.enums;

import lombok.Data;
import lombok.Getter;

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

}
