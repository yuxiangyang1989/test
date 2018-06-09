package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.UserInfoTypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: UserInfo
 * @Description: 用户信息
 * @date 2018-05-30
 * @version:1.0.0
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="loginname")
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
