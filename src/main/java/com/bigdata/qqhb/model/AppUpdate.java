package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: AppUpdate
 * @Description:用户更新版本详情
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class AppUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    private String userCode;
    private String versionNum;
    private String versionSerNum;
    private Date vsersionDate;
}
