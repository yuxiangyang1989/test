package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Openvip;

import java.util.List;

/**
 * @author yang
 * @ClassName: OpenVipService
 * @Description:开通vip/svip功能
 * @date 2018-05-27
 * @version:
 */
public interface OpenVipService {
    /**
     * 是否开通vip以及vip信息
     * @param userCode
     * @return
     * @throws SZBException
     */
    public Openvip vipInfo(String userCode) throws SZBException;

    /**
     * 客户开通vip/svip
     * @param openvip
     * @return
     * @throws SZBException
     */
    public Openvip openVip(Openvip openvip) throws SZBException;
}
