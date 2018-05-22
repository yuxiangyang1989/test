package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class AppUpdate extends BaseModel implements Serializable {
    @Id
    private String userCode;
    private String versionNum;
    private String versionSerNum;
    private Date vsersionDate;
}
