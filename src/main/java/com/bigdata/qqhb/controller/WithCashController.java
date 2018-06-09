package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.qqhb.model.Withcash;
import com.bigdata.qqhb.model.Withdrawals;
import com.bigdata.qqhb.service.WithCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @ClassName: WithCashController
 * @Description:
 * @date 2018-05-28
 * @version:
 */
@RestController
public class WithCashController {

    /*@Autowired
    private WithCashService withCashService;

    *//**
     * 查询余额
     * @param userCode
     * @return ApiOut
     *//*
    @RequestMapping(value="/getBalance")
    public ApiOut<Withcash> getBalance(String userCode){
        ApiOut<Withcash> result = null;
        try {
            result = withCashService.getBalance(userCode);
        } catch (Exception e) {
            result = new ApiOut<Withcash>();
            result.setCode("99999");
            result.setMsg("服务内部错误，请联系管理员");
            e.printStackTrace();
        }
        return result;
    }

    *//**
     * 抽每日红包
     * @param userCode
     * @return
     *//*
    @RequestMapping(value="/getRedbagWithDay")
    public ApiOut<Withdrawals> getRedbagWithDay(String userCode){
        ApiOut<Withdrawals> result = null;
        try {
            result = withCashService.getRedbagWithDay(userCode);
        } catch (Exception e) {
            result = new ApiOut<Withdrawals>();
            result.setCode("99999");
            result.setMsg("服务内部错误，请联系管理员");
            e.printStackTrace();
        }
        return result;
    }*/
}
