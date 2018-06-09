package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: AppList
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class AppList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    private String appdesc;
    private String appimg;
    private String appname;
    private String appurl;
    private String appvsersion;

}
