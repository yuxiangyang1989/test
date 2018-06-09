package com.bigdata.user.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.user.service.UserInfoService;
import com.bigdata.user.vo.UserInfoVo;
import com.bigdata.user.vo.UserLoginVo;
import com.bigdata.user.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yang
 * @ClassName: UserController
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块" ,tags = "用户模块API" ,description = "用户登录注册")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    private static final String API_VER = "api-ver=1.0.0";

    @ApiOperation(value = "用户登录",notes = "用户根据账户密码登录")
    @GetMapping(path = "/login",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<UserInfoVo> login(@Valid UserLoginVo vo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ApiOut.Builder<UserInfoVo>().message(bindingResult.getFieldError().getDefaultMessage()).code(ResponseCode.POST_DATA_FAIL).build();
        }
        return new ApiOut.Builder<UserInfoVo>().code(ResponseCode.SUCCESS).data(new UserInfoVo(userInfoService.findByUsername(vo.toModel()))).build();
    }

    @ApiOperation(value = "用户注册",notes = "用户根据账户密码登录")
    @PostMapping(produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<UserInfoVo> register(@Valid UserRegisterVo vo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ApiOut.Builder<UserInfoVo>().message(bindingResult.getFieldError().getDefaultMessage()).code(ResponseCode.POST_DATA_FAIL).build();
        }
        return new ApiOut.Builder<UserInfoVo>().code(ResponseCode.SUCCESS).data(new UserInfoVo(userInfoService.saveUser(vo.toModel()))).build();
    }
}
