package com.bigdata.szb.handler;

import com.bigdata.enums.szb.ProductType;
import com.bigdata.framework.db.handler.BaseEnumHandler;

/**
 * @author yang
 * @ClassName: EnumAdHandler
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public class EnumProductHandler extends BaseEnumHandler<ProductType> {
    @Override
    public ProductType getEnumeration(int code) {return ProductType.parse(code);}

    @Override
    public int getCode(ProductType enumeration) { return enumeration.getCode();}
}
