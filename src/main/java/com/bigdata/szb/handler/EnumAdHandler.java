package com.bigdata.szb.handler;

import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.framework.db.handler.BaseEnumHandler;

/**
 * @author yang
 * @ClassName: EnumAdHandler
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public class EnumAdHandler extends BaseEnumHandler<AdTypeEnum> {
    @Override
    public AdTypeEnum getEnumeration(int code) {return AdTypeEnum.parse(code);}

    @Override
    public int getCode(AdTypeEnum enumeration) { return enumeration.getCode();}
}
