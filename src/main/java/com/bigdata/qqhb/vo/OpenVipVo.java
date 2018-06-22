package com.bigdata.qqhb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.qqhb.VipEnum;
import com.bigdata.enums.user.VipTypeEnum;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.qqhb.model.Openvip;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yang
 * @ClassName: openVipVo
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Data
public class OpenVipVo extends BaseVo{

    private String openid;//用户ID--手机IMEI唯一标识号
    private VipEnum svip;//SVIP功能
    private VipEnum shenmi;//神秘功能箱
    private VipEnum niuniu;//牛牛
    private VipEnum bikaizuixiaobao;//避开最下
    private VipEnum jiasuqiang;//加速抢
    private VipEnum vip;//vip功能
    private VipEnum guanbiguagngao;//永久去广告
    private VipEnum qiangdabao;//提高最大包
    private VipEnum shouqizuijia;//手气最佳概率
    private VipTypeEnum type;
    private Date expireTime;

    public OpenVipVo(){}
    public OpenVipVo(Openvip openvip){
        this.setSid(NumberUtils.compress(openvip.getId()));
        this.setOpenid(openvip.getOpenid());
        this.setSvip(openvip.getSvip());
        this.setNiuniu(openvip.getNiuniu());
        this.setBikaizuixiaobao(openvip.getBikaizuixiaobao());
        this.setJiasuqiang(openvip.getJiasuqiang());
        this.setVip(openvip.getVip());
        this.setGuanbiguagngao(openvip.getGuanbiguagngao());
        this.setQiangdabao(openvip.getQiangdabao());
        this.setShouqizuijia(openvip.getShouqizuijia());
        this.setCreateTime(openvip.getCreateTime());
        this.setUpdateTime(openvip.getUpdateTime());
        this.setType(openvip.getType());
        this.setExpireTime(openvip.getExpireTime());
    }

    public Openvip toModel(){
        Openvip openvip = new Openvip();
        openvip.setId(NumberUtils.uncompress(this.getSid()));
        openvip.setOpenid(this.getOpenid());
        openvip.setSvip(this.getSvip());
        openvip.setNiuniu(this.getNiuniu());
        openvip.setBikaizuixiaobao(this.getBikaizuixiaobao());
        openvip.setJiasuqiang(this.getJiasuqiang());
        openvip.setVip(this.getVip());
        openvip.setGuanbiguagngao(this.getGuanbiguagngao());
        openvip.setQiangdabao(this.getQiangdabao());
        openvip.setType(this.getType());
        Calendar c = Calendar.getInstance();
        Date today = new Date();
        c.setTime(today);
        switch (this.getType()){
            case VIP_TRY:
                c.add(Calendar.DAY_OF_MONTH, 1);
                openvip.setExpireTime(c.getTime());
                break;
            case VIP_MONTH:
                c.add(Calendar.MONTH, 1);
                openvip.setExpireTime(c.getTime());
                break;
            case VIP_QUARTERLY:
                c.add(Calendar.MONTH, 3);
                openvip.setExpireTime(c.getTime());
                break;
            case VIP_YEAR:
                c.add(Calendar.YEAR, 1);
                openvip.setExpireTime(c.getTime());
                break;
        }

        openvip.setExpireTime(this.getExpireTime());
        return openvip;
    }
}
