package com.bigdata.enums;

/**
 * @author yang
 * @ClassName: IEnumType
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public interface IEnumType {
    /**
     * 数据库中定义的 数字 状态码
     */
    int code();

    /**
     * 简单描述
     */
    String desc();
}
