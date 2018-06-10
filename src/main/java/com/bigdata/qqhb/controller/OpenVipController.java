package com.bigdata.qqhb.controller;

import com.bigdata.abs.AbstractController;
import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.qqhb.model.Openvip;
import com.bigdata.qqhb.service.OpenVipService;
import com.bigdata.qqhb.vo.OpenVipVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yang
 * @ClassName: OpenVipController
 * @Description:vip/svip功能
 * @date 2018-05-28
 * @version:
 */
@Slf4j
@RestController
@RequestMapping(value="/qhb")
@Api(value = "会员信息" ,tags = "会员信息API" ,description = "会员信息")
public class OpenVipController extends AbstractController{
    @Autowired
    private OpenVipService openVipService;
    private static final String API_VER = "api-ver=1.0.0";

    @ApiOperation(value = "获取vip信息",notes = "获取vip信息")
    @GetMapping(path = "/getVipInfo",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<OpenVipVo> getVipInfo(@RequestHeader String token,@RequestHeader String openid){
        if (!validateToken(token,openid))
            return new ApiOut.Builder<OpenVipVo>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return new ApiOut.Builder<OpenVipVo>().data(new OpenVipVo(openVipService.vipInfo(openid))).code(ResponseCode.SUCCESS).build();
    }
    @ApiOperation(value = "获取vip信息",notes = "获取vip信息")
    @PostMapping(path = "/openVip",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<OpenVipVo> openVip(OpenVipVo vo,@RequestHeader String token,@RequestHeader String openid) {
        if (!validateToken(token,openid))
            return new ApiOut.Builder<OpenVipVo>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return new ApiOut.Builder<OpenVipVo>().data(new OpenVipVo(openVipService.openVip(vo.toModel()))).code(ResponseCode.SUCCESS).build();
    }
}
