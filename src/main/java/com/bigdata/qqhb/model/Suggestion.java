package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @ClassName: Suggestion
 * @Description: 投诉建议
 * @date 2018-05-22
 * @version:1.0.0
 */
@Data
@Entity
public class Suggestion extends BaseModel implements Serializable{
    @Id
    private String 	userCode;//用户ID--手机IMEI唯一标识号
    private String msgType;//类型
    private String msg;//问题描述
    private String link;//联系方式
}
