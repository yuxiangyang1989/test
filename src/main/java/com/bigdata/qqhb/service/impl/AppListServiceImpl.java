package com.bigdata.qqhb.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.AppList;
import com.bigdata.qqhb.repository.AppListRepository;
import com.bigdata.qqhb.service.AppListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @ClassName: AppListServiceImpl
 * @Description:
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@Service
public class AppListServiceImpl implements AppListService {

    @Autowired
    private AppListRepository appListRepository;
    @Override
    public List<AppList> findAppAll() throws SZBException {
        return appListRepository.findAll();
    }
}
