package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.qqhb.VipEnum;
import com.bigdata.enums.qqhb.VipTypeEnum;
import com.bigdata.qqhb.enumconvert.VipEnumConvert;
import com.bigdata.qqhb.enumconvert.VipTypeEnumConvert;
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
    @Column(name="expire_time")
    private Date expireTime;

    private String openid;//用户ID--手机IMEI唯一标识号
    @Convert(converter = VipEnumConvert.class)
    private VipEnum svip;//SVIP功能
    @Convert(converter = VipEnumConvert.class)
    private VipEnum shenmi;//神秘功能箱
    @Convert(converter = VipEnumConvert.class)
    private VipEnum niuniu;//牛牛
    @Convert(converter = VipEnumConvert.class)
    private VipEnum bikaizuixiaobao;//避开最小
    @Convert(converter = VipEnumConvert.class)
    private VipEnum jiasuqiang;//加速抢
    @Convert(converter = VipEnumConvert.class)
    private VipEnum vip;//vip功能
    @Convert(converter = VipEnumConvert.class)
    private VipEnum guanbiguagngao;//永久去广告
    @Convert(converter = VipEnumConvert.class)
    private VipEnum qiangdabao;//提高最大包
    @Convert(converter = VipEnumConvert.class)
    private VipEnum shouqizuijia;//手气最佳概率
    @Convert(converter = VipTypeEnumConvert.class)
    private VipTypeEnum type;
}
