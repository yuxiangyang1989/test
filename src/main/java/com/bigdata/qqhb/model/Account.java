package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
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
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    @Column(name = "USER_ID")
    private String userCode;//用户ID--手机IMEI唯一标识号
    @Column(name = "USER_PHONE")
    private String userPhone;//用户手机号
    @Column(name = "CARD_ID")
    private String cardId;//身份证
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;//用户id--自动生成
}
