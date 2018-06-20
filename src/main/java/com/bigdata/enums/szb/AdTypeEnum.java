package com.bigdata.enums.szb;

import com.bigdata.enums.IEnumType;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yang
 * @enumName: AdTypeEnum
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Getter
public enum AdTypeEnum implements IEnumType{

    PSAS(1,"公益广告"),
    COMMERCIAL(2,"商业广告"),
    SHELVES(88,"广告上架"),
    OFFTHESHELF(99,"广告下架");

    private final static Map<Integer, AdTypeEnum> typeMap
            = Arrays.stream(AdTypeEnum.values()).collect(Collectors.toMap(AdTypeEnum::code, type -> type));

    private final static Map<String, AdTypeEnum> typeByNameMap
            = Arrays.stream(AdTypeEnum.values()).collect(Collectors.toMap(type -> type.name().toLowerCase(), type -> type));

    AdTypeEnum(int code,String desc){
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
    public static AdTypeEnum parse(Integer code) {
        return typeMap.get(code);
    }

    /**
     * @param name 名字
     * @return 转换出来的状态码
     */
    public static AdTypeEnum parse(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return typeByNameMap.get(name.trim().toLowerCase());
    }
}
