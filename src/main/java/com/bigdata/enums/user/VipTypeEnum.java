package com.bigdata.enums.user;

import com.bigdata.enums.IEnumType;
import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.framework.common.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yang
 * @enumName: VipTypeEnum
 * @Description:
 * @date 2018-06-23
 * @version:
 */
@Getter
public enum VipTypeEnum implements IEnumType {
    VIP_YEAR(1,"年卡会员"),
    VIP_QUARTERLY(2,"季卡会员"),
    VIP_MONTH(3,"月卡会员"),
    VIP_TRY(4,"试用期会员");

    private final static Map<Integer, VipTypeEnum> typeMap
            = Arrays.stream(VipTypeEnum.values()).collect(Collectors.toMap(VipTypeEnum::code, type -> type));

    private final static Map<String, VipTypeEnum> typeByNameMap
            = Arrays.stream(VipTypeEnum.values()).collect(Collectors.toMap(type -> type.name().toLowerCase(), type -> type));

    VipTypeEnum(int code,String desc){
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
    public static VipTypeEnum parse(Integer code) {
        return typeMap.get(code);
    }

    /**
     * @param name 名字
     * @return 转换出来的状态码
     */
    public static VipTypeEnum parse(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return typeByNameMap.get(name.trim().toLowerCase());
    }
}
