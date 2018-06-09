package com.bigdata.user.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.UserInfoTypeEnum;
import com.bigdata.framework.common.utils.MD5Utils;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.user.model.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: UserRegisterVo
 * @Description:用户注册
 * @date 2018-06-03
 * @version:1.0.0
 */
@Data
@ApiModel(value="user注册对象",description="注册对象user")
public class UserRegisterVo extends BaseVo{
    @NotEmpty(message = "登录号信息不能为空")
    @ApiModelProperty(value="登录名",name="username",example="username",required=true)
    private String loginname;
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value="密码",name="password",example="123456",required=true)
    private String password;
    @NotEmpty(message = "电话不能为空")
    @ApiModelProperty(value="电话",name="phone",example="13888888888",required=true)
    private String phone;
    @ApiModelProperty(value="电子邮箱")
    private String email;
    @ApiModelProperty(value="身份证")
    private String cardId;
    private UserInfoTypeEnum type;
    private Long roleId;
    private Long permissionId;
    private String token;
    private String username;

    public UserInfo toModel(){
        UserInfo userInfo = new UserInfo();
        String salt = MD5Utils.getSalt();
        String password = MD5Utils.getSaltMD5(this.getPassword(),salt);
        Optional.ofNullable(this.getSid()).ifPresent(sid ->userInfo.setId(NumberUtils.uncompress(sid)));
        userInfo.setUsername(this.getUsername());
        userInfo.setPassword(password);
        userInfo.setSalt(salt);
        userInfo.setPhone(this.getPhone());
        userInfo.setEmail(this.getEmail());
        userInfo.setType(this.getType());
        userInfo.setRoleId(this.getRoleId());
        userInfo.setPermissionId(this.getPermissionId());
        userInfo.setLoginName(this.getLoginname());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        return userInfo;
    }
}
