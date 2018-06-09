package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Openvip
 * @Description: 开通vip
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class Openvip implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;

    @Column(name="USER_ID")
    private String userCode;//用户ID--手机IMEI唯一标识号
    private String svip;//SVIP功能
    private String shenmi;//神秘功能箱
    private String niuniu;//牛牛
    private String bikaizuixiaobao;//避开最下
    private String jiasuqiang;//加速抢
    private String vip;//vip功能
    private String guanbiguagngao;//永久去广告
    private String qiangdabao;//提高最大包
    private String shouqizuijia;//手气最佳概率
}
