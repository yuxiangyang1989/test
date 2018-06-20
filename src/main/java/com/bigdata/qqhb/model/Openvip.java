package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.qqhb.VipEnum;
import com.bigdata.enums.qqhb.VipTypeEnum;
import lombok.Data;

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
public class Openvip implements Serializable{


    private Long id;
    private Date updateTime;
    private Date createTime;
    private Date expireTime;

    private String openid;//用户ID--手机IMEI唯一标识号
    private VipEnum svip;//SVIP功能
    private VipEnum shenmi;//神秘功能箱
    private VipEnum niuniu;//牛牛
    private VipEnum bikaizuixiaobao;//避开最小
    private VipEnum jiasuqiang;//加速抢
    private VipEnum vip;//vip功能
    private VipEnum guanbiguagngao;//永久去广告
    private VipEnum qiangdabao;//提高最大包
    private VipEnum shouqizuijia;//手气最佳概率
    private VipTypeEnum type;
}
