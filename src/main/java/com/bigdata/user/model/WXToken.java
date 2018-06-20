package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: WXToken
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Data
public class WXToken extends BaseModel{

    private String accessToken;
    private Long expiresIn;
    private String refreshToken;
    private String openid;
    private String scope;
}
