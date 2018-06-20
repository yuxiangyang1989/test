package com.bigdata.enums.szb;

import com.bigdata.enums.IEnumType;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @ClassName: ProductType
 * @Description:
 * @date 2018-06-21
 * @version:
 */
@Getter
public enum ProductType implements IEnumType {

    WX_RED_BAG(1,"微信红包"),
    PRO_OTHER(99,"其他");

    private final static Map<Integer, ProductType> typeMap
            = Arrays.stream(ProductType.values()).collect(Collectors.toMap(ProductType::code, type -> type));

    private final static Map<String, ProductType> typeByNameMap
            = Arrays.stream(ProductType.values()).collect(Collectors.toMap(type -> type.name().toLowerCase(), type -> type));

    ProductType(int code,String desc){
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
    public static ProductType parse(Integer code) {
        return typeMap.get(code);
    }

    /**
     * @param name 名字
     * @return 转换出来的状态码
     */
    public static ProductType parse(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return typeByNameMap.get(name.trim().toLowerCase());
    }
}
