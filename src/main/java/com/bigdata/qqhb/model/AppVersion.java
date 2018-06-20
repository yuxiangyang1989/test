package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
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
    private String appName;
    private String appDesc;
    private String fileName;
    private String isMustUpdate;
    private String kefuChar;
    private String kefuPhone;
    private String updateUrl;
    private String versionNum;
    private String versionSerNum;
    private Date vsersionDate;
}
