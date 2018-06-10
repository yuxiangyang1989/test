package com.bigdata.szb.enumconvert;

import com.bigdata.enums.szb.StatementType;

import javax.persistence.AttributeConverter;

/**
 * @author yang
 * @ClassName: AdTypeEnumConvert
 * @Description:
 * @date 2018-06-10
 * @version:
 */
public class StatementTypeEnumConvert implements AttributeConverter<StatementType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(StatementType attribute) {
        return attribute.getCode();
    }

    @Override
    public StatementType convertToEntityAttribute(Integer dbData) {
        return StatementType.fromValue(dbData);
    }
}
