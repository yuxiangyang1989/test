package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.pay.model.AliPayInfo;

/**
 * @author yang
 * @ClassName: AliPayService
 * @Description: 支付宝支付信息
 * @date 2018-05-27
 * @version:
 */
public interface AliPayService {

    /**
     * 添加支付宝支付信息
     * @param aliPayInfoVo
     * @return boolean
     */
    public boolean addInfo(AliPayInfo aliPayInfoVo) throws SZBException;
    /**
     * 修改支付宝支付信息
     * @param aliPayInfoVo
     * @return boolean
     */
    public boolean modify(AliPayInfo aliPayInfoVo) throws SZBException;
}
