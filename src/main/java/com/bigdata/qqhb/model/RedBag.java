package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: RedBag
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
public class RedBag implements Serializable{
    private Long id;
    private Date updateTime;
    private Date createTime;
    private String redbagId;
    private String redbag;
}
