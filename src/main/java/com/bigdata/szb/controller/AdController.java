package com.bigdata.szb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.PaginationEntityConverter;
import com.bigdata.szb.model.Ad;
import com.bigdata.szb.service.AdService;
import com.bigdata.szb.vo.AdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yang
 * @ClassName: AdController
 * @Description:
 * @date 2018-06-09
 * @version:
 */
@RestController
@RequestMapping("/szb")
@Api(value = "广告" ,tags = "广告API" ,description = "广告列表")
public class AdController {

    @Autowired
    private AdService adService;

    private static final String API_VER = "api-ver=1.0.0";

    private final PaginationEntityConverter<Ad, AdVo> converter = new PaginationEntityConverter<>();

    @ApiOperation(value = "广告列表",notes = "广告列表")
    @GetMapping(path = "/getAds",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<List<AdVo>> getAdList(){
        return  new ApiOut.Builder<List<AdVo>>().data(converter.toVos(adService.findAll(),this:: toAdVo)).code(ResponseCode.SUCCESS).build();
    }
    private AdVo toAdVo(Ad ad){
        return new AdVo(ad);
    }
}
