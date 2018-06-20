package com.bigdata.enums.szb;

import com.bigdata.enums.IEnumType;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @enumName: StatementType
 * @Description:账单类型
 * @date 2018-05-29
 * @version:1.0.0
 */
@Getter
public enum StatementType implements IEnumType {

    EXPENDITURE(0,"支出"),
    INCOME(1,"收入");

    private final static Map<Integer, StatementType> typeMap
            = Arrays.stream(StatementType.values()).collect(Collectors.toMap(StatementType::code, type -> type));

    private final static Map<String, StatementType> typeByNameMap
            = Arrays.stream(StatementType.values()).collect(Collectors.toMap(type -> type.name().toLowerCase(), type -> type));

    StatementType(int code,String desc){
        this.code = code;
        this.desc =desc;
    }
    private final int code;
    private final String desc;

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    /**
     * @param code 代码
     * @return 转换出来的状态码
     */
    public static StatementType parse(Integer code) {
        return typeMap.get(code);
    }

    /**
     * @param name 名字
     * @return 转换出来的状态码
     */
    public static StatementType parse(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return typeByNameMap.get(name.trim().toLowerCase());
    }


}
