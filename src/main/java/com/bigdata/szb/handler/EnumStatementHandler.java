package com.bigdata.szb.handler;

import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.enums.szb.StatementType;
import com.bigdata.framework.db.handler.BaseEnumHandler;

/**
 * @author yang
 * @ClassName: EnumAdHandler
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public class EnumStatementHandler extends BaseEnumHandler<StatementType> {
    @Override
    public StatementType getEnumeration(int code) {return StatementType.parse(code);}

    @Override
    public int getCode(StatementType enumeration) { return enumeration.getCode();}
}
