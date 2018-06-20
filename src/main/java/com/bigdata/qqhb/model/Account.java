package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Account
 * @Description: 用户信息
 * @date 2018-05-22
 * @version:1.0.0
 */
@Data
public class Account implements Serializable {

    private Long id;
    private Date updateTime;
    private Date createTime;
    private String userCode;//用户ID--手机IMEI唯一标识号
    private String userPhone;//用户手机号
    private String cardId;//身份证
    private Integer accountId;//用户id--自动生成
}
