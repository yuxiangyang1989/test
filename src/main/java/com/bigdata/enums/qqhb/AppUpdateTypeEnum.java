package com.bigdata.enums.qqhb;

import com.bigdata.enums.IEnumType;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @ClassName: AppUpdate
 * @Description:
 * @date 2018-06-24
 * @version:
 */
@Getter
public enum AppUpdateTypeEnum implements IEnumType {
    FORCE(0,"强制更新"),
    NONCOERCIVE(1,"非强制更新");

    private final static Map<Integer, AppUpdateTypeEnum> typeMap
            = Arrays.stream(AppUpdateTypeEnum.values()).collect(Collectors.toMap(AppUpdateTypeEnum::code, type -> type));

    private final static Map<String, AppUpdateTypeEnum> typeByNameMap
            = Arrays.stream(AppUpdateTypeEnum.values()).collect(Collectors.toMap(type -> type.name().toLowerCase(), type -> type));

    AppUpdateTypeEnum(int code,String desc){
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
    public static AppUpdateTypeEnum parse(Integer code) {
        return typeMap.get(code);
    }

    /**
     * @param name 名字
     * @return 转换出来的状态码
     */
    public static AppUpdateTypeEnum parse(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return typeByNameMap.get(name.trim().toLowerCase());
    }
}
