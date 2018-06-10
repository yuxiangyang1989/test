package com.bigdata.user.vo;

import com.bigdata.user.model.WXUserInfo;
import lombok.Data;

/**
 * @author yang
 * @ClassName: WXUserInfo
 * @Description:微信用户信息
 * @date 2018-06-09
 * @version:
 */
@Data
public class WXUserInfoVo {
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String privilege;
    private String unionid;

    public WXUserInfo toModel(){
        WXUserInfo wxUserInfo = new WXUserInfo();
        wxUserInfo.setOpenid(this.openid);
        wxUserInfo.setNickname(this.nickname);
        wxUserInfo.setSex(this.sex);
        wxUserInfo.setProvince(this.province);
        wxUserInfo.setCity(this.city);
        wxUserInfo.setCountry(this.country);
        wxUserInfo.setHeadimgurl(this.headimgurl);
        wxUserInfo.setPrivilege(this.privilege);
        wxUserInfo.setUnionid(this.unionid);
        return wxUserInfo;
    }
}
