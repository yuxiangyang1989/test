package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.qqhb.AppUpdateTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: AppVersion
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
public class AppVersion extends BaseModel {
    private String appDesc;
    private String appName;
    private String fileName;
    private AppUpdateTypeEnum isMustUpdate;
    private String kefuChar;
    private String kefuPhone;
    private String updateUrl;
    private String versionNum;
    private String versionSerNum;
    private Date vsersionDate;
}
