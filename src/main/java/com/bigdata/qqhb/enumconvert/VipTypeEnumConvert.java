package com.bigdata.qqhb.enumconvert;

import com.bigdata.enums.qqhb.VipTypeEnum;

import javax.persistence.AttributeConverter;

/**
 * @author yang
 * @ClassName: VipEnumConvert
 * @Description:
 * @date 2018-06-10
 * @version:
 */
public class VipTypeEnumConvert implements AttributeConverter<VipTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(VipTypeEnum attribute) {
        return attribute.getCode();
    }

    @Override
    public VipTypeEnum convertToEntityAttribute(Integer dbData) {
        return VipTypeEnum.fromValue(dbData);
    }
}
