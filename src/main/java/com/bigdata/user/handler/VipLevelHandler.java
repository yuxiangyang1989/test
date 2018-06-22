package com.bigdata.user.handler;

import com.bigdata.enums.user.VipTypeEnum;
import com.bigdata.framework.db.handler.BaseEnumHandler;

/**
 * @author yang
 * @ClassName: VipLevelHandler
 * @Description:
 * @date 2018-06-23
 * @version:
 */
public class VipLevelHandler extends BaseEnumHandler<VipTypeEnum> {
    @Override
    public VipTypeEnum getEnumeration(int code) {return VipTypeEnum.parse(code);}

    @Override
    public int getCode(VipTypeEnum enumeration) { return enumeration.getCode();}
}
