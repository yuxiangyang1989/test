package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.qqhb.model.AppList;
import com.bigdata.qqhb.service.AppListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yang
 * @ClassName: AppListController
 * @Description:精品列表
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@RestController
@RequestMapping(value="/appList")
public class AppListController {

    @Autowired
    private AppListService appListService;
    /**
     * 获取精品列表
     * @return Result<AppListVo>
     */
    @GetMapping
    public ApiOut<List<AppList>> getAppList(){
        return new ApiOut.Builder<List<AppList>>().data(appListService.findAppAll()).code(ResponseCode.SUCCESS).build();
    }
}
