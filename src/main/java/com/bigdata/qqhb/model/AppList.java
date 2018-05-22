package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @ClassName: AppList
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class AppList extends BaseModel implements Serializable {
    @Id
    private String id;
    private String appdesc;
    private String appimg;
    private String appname;
    private String appurl;
    private String appvsersion;

}
