package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.qqhb.service.SuggestionService;
import com.bigdata.qqhb.vo.SuggestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yang
 * @ClassName: SuggestionController
 * @Description:投诉与建议
 * @date 2018-05-28
 * @version:
 */
public class SuggestionController {

    @Autowired
    private SuggestionService service;

    @RequestMapping(value="/addUserMsg")
    public ApiOut<SuggestionVo> addSuggestion(SuggestionVo vo){
        return new ApiOut.Builder<SuggestionVo>().data(new SuggestionVo(service.add(vo.toModel()))).code(ResponseCode.SUCCESS).build();
    }

}
