package com.bigdata.user.vo;

import com.bigdata.enums.user.UserInfoTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yang
 * @ClassName: SimpleUser
 * @Description:
 * @date 2018-06-05
 * @version:
 */
@Data
public class SimpleUser implements Serializable {
    private Long id;
    private String loginname;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private UserInfoTypeEnum type;
    private Long roleId;
    private Long permissionId;
    private String token;
    private String username;


}
