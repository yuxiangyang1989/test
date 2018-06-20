package com.bigdata.szb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.szb.AdTypeEnum;
import lombok.Data;


/**
 * @author yang
 * @ClassName: Ad
 * @Description:广告
 * @date 2018-06-09
 * @version:
 */
@Data
public class Ad extends BaseModel{
    private String url;
    private String adUrl;
    private AdTypeEnum validity;
    private AdTypeEnum type;
    private Integer priority;
}
