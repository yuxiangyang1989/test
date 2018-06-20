package com.bigdata.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @enumName: StateCode
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public enum StateCode implements IEnumType {
    Inactive(0, "无效"),
    Disabled(1, "禁用"),
    Initial(2, "初始化"),//初始化状态，非有效状态，如草稿状态
    Active(5, "有效"),       // 默认有效状态
    Underway(6, "进行中");

    private final static Map<Integer, StateCode> stateMap
            = Arrays.stream(StateCode.values()).collect(Collectors.toMap(StateCode::code, code -> code));

    private final static Map<String, StateCode> stateByNameMap
            = Arrays.stream(StateCode.values()).collect(Collectors.toMap(code -> code.name().toLowerCase(), code -> code));
    private final int code;
    private final String desc;
    /**
     * @param code 代码
     * @param desc 描述
     */
    StateCode(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int code() {return this.code;}

    @Override
    public String desc() {return this.desc; }
}
