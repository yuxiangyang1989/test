package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.PaginationEntityConverter;
import com.bigdata.qqhb.model.AppUpdate;
import com.bigdata.qqhb.model.AppVersion;
import com.bigdata.qqhb.service.AppVersionService;
import com.bigdata.qqhb.vo.AppUpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/appVersion")
public class AppVersionController {

    @Autowired
    private AppVersionService appVersionService;
    /**
     * 检查更新版本
     * @param userCode
     * @param versionNum
     * @param versionSerNum
     * @return Result<AppVersionVo>
     */
    public ApiOut<AppVersion> checkVersion(String userCode, String versionNum, String versionSerNum){
        return new ApiOut.Builder<AppVersion>().data(appVersionService.getAppVersion()).code(ResponseCode.SUCCESS).build();
    }

}
