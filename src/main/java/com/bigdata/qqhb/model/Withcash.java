package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @ClassName: Withcash
 * @Description: 每日红包余额
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class Withcash extends BaseModel implements Serializable{
    @Id
    private String userCode;
    private String balance;
}
