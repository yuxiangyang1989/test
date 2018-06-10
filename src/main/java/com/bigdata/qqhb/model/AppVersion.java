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
@Table(name = "app_version")
public class AppVersion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "app_desc")
    private String appDesc;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "is_must_update")
    private String isMustUpdate;
    @Column(name = "kefu_char")
    private String kefuChar;
    @Column(name = "kefu_phone")
    private String kefuPhone;
    @Column(name = "update_url")
    private String updateUrl;
    @Column(name = "version_num")
    private String versionNum;
    @Column(name = "version_ser_num")
    private String versionSerNum;
    @Column(name = "vsersion_date")
    private Date vsersionDate;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
