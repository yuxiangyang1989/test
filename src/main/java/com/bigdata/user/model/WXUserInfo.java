package com.bigdata.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: WXUserInfo
 * @Description:微信用户信息
 * @date 2018-06-09
 * @version:
 */
@Data
@Entity
@Table(name = "wx_user_info")
public class WXUserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String privilege;
    private String unionid;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;

}
