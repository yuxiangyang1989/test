package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.PaginationEntityConverter;
import com.bigdata.qqhb.model.AppUpdate;
import com.bigdata.qqhb.model.AppVersion;
import com.bigdata.qqhb.service.AppVersionService;
import com.bigdata.qqhb.vo.AppUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yang
 * @ClassName: AppVersionController
 * @Description:app版本控制
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@RestController
@RequestMapping(value="/qhb")
@Api(value = "版本信息" ,tags = "版本信息API" ,description = "版本信息")
public class AppVersionController {

    private static final String API_VER = "api-ver=1.0.0";
    @Autowired
    private AppVersionService appVersionService;

    @ApiOperation(value = "获取app版本",notes = "获取app版本")
    @GetMapping(path = "/getVersion",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiOut<AppVersion> checkVersion(){
        return new ApiOut.Builder<AppVersion>().data(appVersionService.getAppVersion()).code(ResponseCode.SUCCESS).build();
    }

}
