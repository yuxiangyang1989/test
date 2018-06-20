package com.bigdata.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yang
 * @ClassName: ForgetVo
 * @Description:
 * @date 2018-06-19
 * @version:
 */
@Data
public class ForgetVo {

    @NotEmpty(message = "登录号信息不能为空")
    @ApiModelProperty(value="登录名",name="username",example="username",required=true)
    private String loginname;
    @NotEmpty(message = "手机号不能为空")
    @ApiModelProperty(value="手机号",name="phone",example="1388888888",required=true)
    private String phone;
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value="密码",name="password",example="123456",required=true)
    private String password;
    @NotEmpty(message = "验证密码不能为空")
    @ApiModelProperty(value="验证密码",name="valiPassword",example="123456",required=true)
    private String valiPassword;
    @NotEmpty(message = "验证码不能为空")
    @ApiModelProperty(value="验证码",name="verCode",example="123456",required=true)
    private String verCode;

}
