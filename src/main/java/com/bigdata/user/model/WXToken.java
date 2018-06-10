package com.bigdata.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: WXToken
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@Data
@Entity
@Table(name = "user_token")
public class WXToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "expires_in")
    private Long expiresIn;
    @Column(name = "refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
}
