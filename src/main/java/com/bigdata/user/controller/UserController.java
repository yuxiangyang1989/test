package com.bigdata.user.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.user.service.UserInfoService;
import com.bigdata.user.vo.*;
import com.github.qcloudsms.SmsSingleSenderResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yang
 * @ClassName: UserController
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户模块" ,tags = "用户模块API" ,description = "用户登录注册")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    private static final String API_VER = "api-ver=1.0.0";

    @ApiOperation(value = "用户登录",notes = "用户根据账户密码登录")
    @GetMapping(path = "/login",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<UserInfoVo> login(@Valid UserLoginVo vo, BindingResult bindingResult,final HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return new ApiOut.Builder<UserInfoVo>().message(bindingResult.getFieldError().getDefaultMessage()).code(ResponseCode.POST_DATA_FAIL).build();
        }
        UserInfoVo infoVo = new UserInfoVo(userInfoService.findByUsername(vo.toModel()));
        request.setAttribute(infoVo.getSid(),infoVo);
        return new ApiOut.Builder<UserInfoVo>().code(ResponseCode.SUCCESS).data(infoVo).build();
    }

    @ApiOperation(value = "用户注册",notes = "用户根据账户密码登录")
    @PostMapping(produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<UserInfoVo> register(@Valid UserRegisterVo vo, BindingResult bindingResult,final HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return new ApiOut.Builder<UserInfoVo>().message(bindingResult.getFieldError().getDefaultMessage()).code(ResponseCode.POST_DATA_FAIL).build();
        }
        final HttpSession httpSession=request.getSession();
        String verCode = (String)httpSession.getAttribute(vo.getPhone());
        if (!verCode.equals(vo.getVerCode()))
            return new ApiOut.Builder<UserInfoVo>().message("验证码不正确或不存在").code(ResponseCode.LOGIN_ERROR).build();
        return new ApiOut.Builder<UserInfoVo>().code(ResponseCode.SUCCESS).data(new UserInfoVo(userInfoService.saveUser(vo.toModel()))).build();
    }

    @ApiOperation(value = "忘记密码",notes = "忘记密码")
    @PostMapping(path = "/forget",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<UserInfoVo> forget(@Valid ForgetVo vo, BindingResult bindingResult, final HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return new ApiOut.Builder<UserInfoVo>().message(bindingResult.getFieldError().getDefaultMessage()).code(ResponseCode.POST_DATA_FAIL).build();
        }
        final HttpSession httpSession=request.getSession();
        String verCode = (String)httpSession.getAttribute(vo.getPhone());
        if (!verCode.equals(vo.getVerCode()))
            return new ApiOut.Builder<UserInfoVo>().message("验证码不正确或不存在").code(ResponseCode.LOGIN_ERROR).build();
        if (!vo.getPassword().equals(vo.getValiPassword()))
            return new ApiOut.Builder<UserInfoVo>().message("两次密码不一致,请重新输入").code(ResponseCode.LOGIN_ERROR).build();
        UserInfoVo infoVo = new UserInfoVo();
        infoVo.setLoginname(vo.getLoginname());
        infoVo.setPassword(vo.getPassword());
        return new ApiOut.Builder<UserInfoVo>().code(ResponseCode.SUCCESS).data(new UserInfoVo(userInfoService.forgetPassword(infoVo.toModel()))).build();
    }


    @ApiOperation(value = "发送短信验证码",notes = "发送短信验证码")
    @GetMapping(value = "/phone",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<MsgVo> msgCode(String phone,final HttpServletRequest request){
        MsgVo vo = userInfoService.sendMsg(phone);
        final HttpSession httpSession=request.getSession();
        //TimerTask实现5分钟后从session中删除checkCode
        httpSession.setAttribute(phone,vo.getCode());
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                httpSession.removeAttribute(phone);
                log.info("{}的短信验证码失效,失效验证码为{}",phone,vo.getCode());
                timer.cancel();
            }
        },5*60*1000);
        return new ApiOut.Builder<MsgVo>().code(ResponseCode.SUCCESS).data(vo).build();
    }
}
