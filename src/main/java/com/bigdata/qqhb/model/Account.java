package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @ClassName: Account
 * @Description: 用户信息
 * @date 2018-05-22
 * @version:1.0.0
 */
@Data
@Entity
public class Account extends BaseModel implements Serializable {

    @Id
    @Column(name = "USER_ID")
    private String userCode;//用户ID--手机IMEI唯一标识号
    @Column(name = "USER_PHONE")
    private String userPhone;//用户手机号
    @Column(name = "CARD_ID")
    private String cardId;//身份证
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;//用户id--自动生成
}
