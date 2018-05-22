package com.bigdata.apiout;

import java.io.Serializable;
import java.util.List;

/**
 * @author yang
 * @ClassName: ApiOut
 * @Description:接口统一返回
 * @date 2018-05-22
 * @version:1.0.0
 */
public class ApiOut<T> implements Serializable{
    private String code;
    private String msg;
    private String detail;
    private List<T> data;
}
