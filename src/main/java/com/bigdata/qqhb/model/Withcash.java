package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Withcash
 * @Description: 每日红包余额
 * @date 2018-05-22
 * @version:
 */
@Data
public class Withcash implements Serializable{

    private Long id;
    private Date updateTime;
    private Date createTime;
    private String userCode;
    private String balance;
}
