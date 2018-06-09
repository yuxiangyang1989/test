package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
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
public class AppVersion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
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
