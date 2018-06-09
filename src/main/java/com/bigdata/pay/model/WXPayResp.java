package com.bigdata.pay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yang
 * @ClassName: WXPayResp
 * @Description:微信回调信息
 * @date 2018-05-27
 * @version:
 */
@Data
public class WXPayResp implements Serializable {
    private String errCode;
}
