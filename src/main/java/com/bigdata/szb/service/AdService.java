package com.bigdata.szb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.szb.model.Ad;

import java.util.List;

/**
 * @author yang
 * @ClassName: AdService
 * @Description:
 * @date 2018-06-09
 * @version:
 */
public interface AdService {

    public List<Ad> findAll() throws SZBException;
}
