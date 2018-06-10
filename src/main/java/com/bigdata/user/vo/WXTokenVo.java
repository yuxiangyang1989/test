package com.bigdata.user.vo;

import com.bigdata.user.model.WXToken;
import lombok.Data;

/**
 * @author yang
 * @ClassName: WXTokenVo
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Data
public class WXTokenVo {
    private String access_token;
    private Long expires_in;
    private String refresh_token;
    private String openid;
    private String scope;

    public WXToken toModel(){
        WXToken token = new WXToken();
        token.setAccessToken(this.access_token);
        token.setExpiresIn(this.expires_in);
        token.setRefreshToken(this.refresh_token);
        token.setOpenid(this.openid);
        token.setScope(this.scope);
        return token;
    }
}
