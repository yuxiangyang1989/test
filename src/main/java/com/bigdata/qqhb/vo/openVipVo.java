package com.bigdata.qqhb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.qqhb.model.Openvip;
import lombok.Data;

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

    public OpenVipVo(){}
    public OpenVipVo(Openvip openvip){
        this.setSid(NumberUtils.compress(openvip.getId()));
        this.setUserCode(openvip.getUserCode());
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
    }

    public Openvip toModel(){
        Openvip openvip = new Openvip();
        openvip.setId(NumberUtils.uncompress(this.getSid()));
        openvip.setUserCode(this.getUserCode());
        openvip.setSvip(this.getSvip());
        openvip.setNiuniu(this.getNiuniu());
        openvip.setBikaizuixiaobao(this.getBikaizuixiaobao());
        openvip.setJiasuqiang(this.getJiasuqiang());
        openvip.setVip(this.getVip());
        openvip.setGuanbiguagngao(this.getGuanbiguagngao());
        openvip.setQiangdabao(this.getQiangdabao());
        return openvip;
    }
}
