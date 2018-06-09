package com.bigdata.pay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yang
 * @ClassName: WXInfoVo
 * @Description:微信支付信息
 * @date 2018-05-27
 * @version:
 */
@Data
public class WXInfoVo implements Serializable {
    private String appid;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private String timestamp;
    private String packages;
    private String sign;
}
