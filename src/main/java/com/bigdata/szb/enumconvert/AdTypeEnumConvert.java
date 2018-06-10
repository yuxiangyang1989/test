package com.bigdata.szb.enumconvert;

import com.bigdata.enums.szb.AdTypeEnum;

import javax.persistence.AttributeConverter;

/**
 * @author yang
 * @ClassName: AdTypeEnumConvert
 * @Description:
 * @date 2018-06-10
 * @version:
 */
public class AdTypeEnumConvert implements AttributeConverter<AdTypeEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AdTypeEnum attribute) {
        return attribute.getCode();
    }

    @Override
    public AdTypeEnum convertToEntityAttribute(Integer dbData) {
        return AdTypeEnum.fromValue(dbData);
    }
}
