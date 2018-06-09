package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.qqhb.model.Openvip;
import com.bigdata.qqhb.service.OpenVipService;
import com.bigdata.qqhb.vo.OpenVipVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value="/openVip")
public class OpenVipController {
    @Autowired
    private OpenVipService openVipService;

    @RequestMapping(value="/getUserInfo")
    public ApiOut<OpenVipVo> getUserInfo(String userCode){
        return new ApiOut.Builder<OpenVipVo>().data(new OpenVipVo(openVipService.vipInfo(userCode))).code(ResponseCode.SUCCESS).build();
    }
    /**
     * 开通vip
     * @param vo
     * @return ApiOut
     */
    @RequestMapping(value="/openVip")
    public ApiOut<OpenVipVo> openVip(OpenVipVo vo) {
        return new ApiOut.Builder<OpenVipVo>().data(new OpenVipVo(openVipService.openVip(vo.toModel()))).code(ResponseCode.SUCCESS).build();
    }
}
