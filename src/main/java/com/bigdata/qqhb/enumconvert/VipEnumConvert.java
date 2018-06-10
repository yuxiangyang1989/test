package com.bigdata.qqhb.enumconvert;

import com.bigdata.enums.qqhb.VipEnum;

import javax.persistence.AttributeConverter;

/**
 * @author yang
 * @ClassName: VipEnumConvert
 * @Description:
 * @date 2018-06-10
 * @version:
 */
public class VipEnumConvert implements AttributeConverter<VipEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(VipEnum attribute) {
        return attribute.getCode();
    }

    @Override
    public VipEnum convertToEntityAttribute(Integer dbData) {
        return VipEnum.fromValue(dbData);
    }
}
