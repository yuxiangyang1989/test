package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.pay.model.WXInfoVo;
import com.bigdata.pay.model.WXPayResp;

/**
 * @author yang
 * @ClassName: WeCharService
 * @Description: 微信支付接口
 * @date 2018-05-27
 * @version:
 */
public interface WeCharService {
    /**
     * 添加微信支付信息
     * @param wxInfoVo
     * @param wxPayResp
     * @return boolean
     */
    public boolean addInfo(WXInfoVo wxInfoVo , WXPayResp wxPayResp) throws SZBException;
    /**
     * 修改微信支付信息
     * @param wxInfoVo
     * @param wxPayResp
     * @return boolean
     */
    public boolean modify(WXInfoVo wxInfoVo,WXPayResp wxPayResp) throws SZBException;
}
