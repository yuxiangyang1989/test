package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity
public class AppVersion extends BaseModel implements Serializable {
    @Id
    private String id;
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
