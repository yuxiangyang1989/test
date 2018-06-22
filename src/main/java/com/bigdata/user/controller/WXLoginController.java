package com.bigdata.user.controller;

import com.bigdata.abs.AbstractController;
import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.user.model.VipInfoDao;
import com.bigdata.user.model.WXToken;
import com.bigdata.user.model.WXUserInfo;
import com.bigdata.user.service.WXService;
import com.bigdata.user.vo.WXTokenVo;
import com.bigdata.user.vo.WXUserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author yang
 * @ClassName: WXLoginController
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@RestController
@RequestMapping("/wx")
@Api(value = "微信授权" ,tags = "微信用户模块API" ,description = "用户授权")
public class WXLoginController extends AbstractController{

    @Autowired
    private WXService wxService;

    private static final String API_VER = "api-ver=1.0.0";

    @ApiOperation(value = "获取code",notes = "获取code")
    @GetMapping(path = "/getCode",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<String> getCode() {
        return  new ApiOut.Builder<String>().code(ResponseCode.SUCCESS).data(wxService.getCode()).build();
    }

    @ApiOperation(value = "获取token",notes = "通过code获取token")
    @GetMapping(path = "/callback",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<WXTokenVo> getAccessToken(String code){
        if (StringUtils.isEmpty(code))
            return new ApiOut.Builder<WXTokenVo>().code(ResponseCode.POST_DATA_FAIL).message("code不能为空").build();
        return new ApiOut.Builder<WXTokenVo>().code(ResponseCode.SUCCESS).data(wxService.getAccessToken(code)).build();
    }

    @ApiOperation(value = "刷新token",notes = "刷新token")
    @GetMapping(path = "/refreshToken",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<WXTokenVo> refreshToken(String refreshToken){
        if (StringUtils.isEmpty(refreshToken))
            return new ApiOut.Builder<WXTokenVo>().code(ResponseCode.POST_DATA_FAIL).message("refreshToken不能为空").build();
        return new ApiOut.Builder<WXTokenVo>().code(ResponseCode.SUCCESS).data(wxService.refreshToken(refreshToken)).build();
    }

    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @GetMapping(path = "/getUserInfo",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<WXUserInfoVo> getUserInfo(@RequestHeader String token,@RequestHeader String openid)  {
        if (StringUtils.isEmpty(token))
            return new ApiOut.Builder<WXUserInfoVo>().code(ResponseCode.POST_DATA_FAIL).message("token不能为空").build();
        if (StringUtils.isEmpty(openid))
            return new ApiOut.Builder<WXUserInfoVo>().code(ResponseCode.POST_DATA_FAIL).message("openid不能为空").build();
        return new ApiOut.Builder<WXUserInfoVo>().code(ResponseCode.SUCCESS).data(wxService.getUserInfo(token,openid)).build();
    }

    @ApiOperation(value = "存储用户信息",notes = "存储用户信息")
    @PostMapping(path = "/info",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<String> wxUserInfo(WXToken token, WXUserInfo wxUserInfo){
        wxService.save(token,wxUserInfo);
        return new ApiOut.Builder<String>().message("储存用户信息成功").code(ResponseCode.SUCCESS).build();
    }

    @ApiOperation(value = "获取vip信息",notes = "获取vip信息")
    @GetMapping(path = "/getVipInfo",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<VipInfoDao> getVipInfo(String openid,@RequestHeader String token) {
        if (!validateToken(token,openid))
            return new ApiOut.Builder<VipInfoDao>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return  new ApiOut.Builder<VipInfoDao>().code(ResponseCode.SUCCESS).data(wxService.getVipInfo(openid)).build();
    }

}
