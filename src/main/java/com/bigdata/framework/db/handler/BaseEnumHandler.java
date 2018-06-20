package com.bigdata.framework.db.handler;

import com.bigdata.enums.IEnumType;

/**
 * @author yang
 * @ClassName: BaseEnumHandler
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public abstract class BaseEnumHandler<T extends IEnumType> extends BaseObjectHandler<T> {

    /**
     * 通过数字(存储在DB中)获取得枚举
     *
     * @param code 代码
     * @return
     */
    public abstract T getEnumeration(int code);

    @Override
    public T getObject(int code) {
        return getEnumeration(code);
    }
}
