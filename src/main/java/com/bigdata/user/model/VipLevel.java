package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.user.VipTypeEnum;
import lombok.Data;

/**
 * @author yang
 * @ClassName: VipLevel
 * @Description:
 * @date 2018-06-23
 * @version:
 */
@Data
public class VipLevel extends BaseModel {
    private String openid;
    private VipTypeEnum vipType;
}
