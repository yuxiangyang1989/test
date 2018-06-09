package com.bigdata.qqhb.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.AppUpdate;
import com.bigdata.qqhb.model.AppVersion;
import com.bigdata.qqhb.repository.AppVersionRepository;
import com.bigdata.qqhb.service.AppVersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @ClassName: AppVersionServiceImpl
 * @Description:
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionRepository appVersionRepository;
    @Override
    public AppVersion getAppVersion() throws SZBException {
        Sort sort = new Sort(Sort.Direction.DESC,"create_time");
        return appVersionRepository.findAll(sort).get(0);
    }

    @Override
    public boolean addVersionInfo(AppUpdate appUpdateVo) throws SZBException {
        return false;
    }
}

