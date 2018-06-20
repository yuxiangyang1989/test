package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;
import java.util.Date;

/**
 * @author yang
 * @ClassName: WXUserInfo
 * @Description:微信用户信息
 * @date 2018-06-09
 * @version:
 */
@Data
public class WXUserInfo extends BaseModel{
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String privilege;
    private String unionid;
}
