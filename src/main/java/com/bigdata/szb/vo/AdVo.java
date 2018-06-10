package com.bigdata.szb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.szb.model.Ad;
import lombok.Data;

/**
 * @author yang
 * @ClassName: AdVo
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Data
public class AdVo extends BaseVo{

    private String url;
    private String adUrl;
    private AdTypeEnum validity;
    private AdTypeEnum type;
    private Integer priority;

    public AdVo(){}

    public AdVo(Ad ad){
        this.setSid(NumberUtils.compress(ad.getId()));
        this.setUrl(ad.getUrl());
        this.setAdUrl(ad.getAdUrl());
        this.setType(ad.getType());
        this.setValidity(ad.getValidity());
        this.setCreateTime(ad.getCreateTime());
        this.setUpdateTime(ad.getUpdateTime());
        this.setPriority(ad.getPriority());
    }
}
