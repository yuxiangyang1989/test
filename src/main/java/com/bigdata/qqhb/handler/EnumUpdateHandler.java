package com.bigdata.qqhb.handler;

import com.bigdata.enums.qqhb.AppUpdateTypeEnum;
import com.bigdata.framework.db.handler.BaseEnumHandler;

/**
 * @author yang
 * @ClassName: EnumAdHandler
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public class EnumUpdateHandler extends BaseEnumHandler<AppUpdateTypeEnum> {
    @Override
    public AppUpdateTypeEnum getEnumeration(int code) {return AppUpdateTypeEnum.parse(code);}

    @Override
    public int getCode(AppUpdateTypeEnum enumeration) { return enumeration.getCode();}
}
