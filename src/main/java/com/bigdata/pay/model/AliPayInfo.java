package com.bigdata.pay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yang
 * @ClassName: AliPayInfo
 * @Description: 阿里支付信息实体类
 * @date 2018-05-27
 * @version:
 */
@Data
public class AliPayInfo implements Serializable {
    private String private_key_path;
    private String seller_id;
    private String partner;//签约合作者ID
    private String oderid;//无
    private String out_trade_no;
    private String subject;
    private String body;
    private String total_fee;
    private String notify_url;
}
