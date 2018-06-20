package com.bigdata.user.model;

import com.bigdata.enums.user.UserInfoTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: UserInfo
 * @Description: 用户信息
 * @date 2018-05-30
 * @version:1.0.0
 */
@Data
public class UserInfo{

    private Long id;
    private Date updateTime;
    private Date createTime;
    private String loginName;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private String cardId;
    private UserInfoTypeEnum type;
    private Long roleId;
    private Long permissionId;
}
