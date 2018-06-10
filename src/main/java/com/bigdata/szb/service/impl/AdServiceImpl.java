package com.bigdata.szb.service.impl;

import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.exception.SZBException;
import com.bigdata.szb.model.Ad;
import com.bigdata.szb.repository.AdRepository;
import com.bigdata.szb.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yang
 * @ClassName: AdService
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;
    @Override
    public List<Ad> findAll() throws SZBException {
        return adRepository.findAll().stream().filter(ads-> AdTypeEnum.SHELVES.equals(ads.getValidity())).sorted(Comparator.comparing(Ad::getPriority)).collect(Collectors.toList());
    }
}
