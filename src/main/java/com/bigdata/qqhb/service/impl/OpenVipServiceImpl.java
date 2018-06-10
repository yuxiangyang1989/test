package com.bigdata.qqhb.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Openvip;
import com.bigdata.qqhb.repository.VipRepository;
import com.bigdata.qqhb.service.OpenVipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @ClassName: OpenVipServiceImpl
 * @Description:
 * @date 2018-05-28
 * @version:
 */
@Slf4j
@Service
public class OpenVipServiceImpl implements OpenVipService {

    @Autowired
    private VipRepository vipRepository;

    @Override
    public Openvip vipInfo(String openid) throws SZBException {
        return vipRepository.findByOpenid(openid);
    }

    @Override
    public Openvip openVip(Openvip openvip) throws SZBException {
        return vipRepository.save(openvip);
    }


}
