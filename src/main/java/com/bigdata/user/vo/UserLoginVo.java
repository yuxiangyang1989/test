package com.bigdata.user.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.user.model.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yang
 * @ClassName: UserLoginVo
 * @Description:用户登录
 * @date 2018-06-03
 * @version:1.0.0
 */
@Data
@ApiModel(value="user登录对象",description="用户登录对象user")
public class UserLoginVo extends BaseVo{
    @NotEmpty(message = "登录号信息不能为空")
    @ApiModelProperty(value="登录名",name="username",example="username",required=true)
    private String loginname;
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value="密码",name="password",example="123456",required=true)
    private String password;

    public UserLoginVo(){}

    public UserLoginVo(UserInfo userInfo){
        this.loginname = userInfo.getLoginName();
        this.password = userInfo.getPassword();
    }

    public UserInfo toModel(){
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(this.getPassword());
        userInfo.setLoginName(this.getLoginname());
        return userInfo;
    }
}
