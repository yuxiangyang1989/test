package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Suggestion
 * @Description: 投诉建议
 * @date 2018-05-22
 * @version:1.0.0
 */
@Data
@Entity
public class Suggestion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;

    private String 	userCode;//用户ID--手机IMEI唯一标识号
    private String msgType;//类型
    private String msg;//问题描述
    private String link;//联系方式
}
