package com.bigdata.szb.controller;

import com.bigdata.abs.AbstractController;
import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.PaginationEntityConverter;
import com.bigdata.szb.model.Statement;
import com.bigdata.szb.service.StatementService;
import com.bigdata.szb.vo.BillVo;
import com.bigdata.szb.vo.StatementRankVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * @ClassName: StatementController
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@RestController
@RequestMapping("/szb")
@Api(value = "对账单" ,tags = "对账单API" ,description = "对账单信息")
public class StatementController extends AbstractController {

    private static final String API_VER = "api-ver=1.0.0";

    @Autowired
    private StatementService statementService;

    private final PaginationEntityConverter<Statement, BillVo> converter = new PaginationEntityConverter<>();
    private final PaginationEntityConverter<Statement, StatementRankVo> converterRank = new PaginationEntityConverter<>();

    @ApiOperation(value = "账单流水",notes = "账单流水")
    @GetMapping(path = "/getBills",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<List<BillVo>> getList(BillVo vo, @RequestHeader String token){
        if (!validateToken(token,vo.getOpenid()))
            return new ApiOut.Builder<List<BillVo>>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return new ApiOut.Builder<List<BillVo>>().data(converter.toVos(statementService.findBillList(vo.getOpenid(),vo.getPage(),vo.getSize(),vo.getStime(),vo.getEtime()),this::toBillVo)).code(ResponseCode.SUCCESS).build();
    }

    @ApiOperation(value = "修改备注",notes = "修改备注")
    @PostMapping(path = "/modify",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<BillVo> modify(BillVo vo, @RequestHeader String token){
        if (!validateToken(token,vo.getOpenid()))
            return new ApiOut.Builder<BillVo>().message("token失效").code(ResponseCode.TokenInvalid).build();

        return new ApiOut.Builder<BillVo>().data(new BillVo(statementService.modify(vo.toModel()))).code(ResponseCode.SUCCESS).build();
    }

    @ApiOperation(value = "总额排行",notes = "总额排行")
    @GetMapping(path = "/getBillRank",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<List<BillVo>> getBillListRank(BillVo vo, @RequestHeader String token){
        if (!validateToken(token,vo.getOpenid()))
            return new ApiOut.Builder<List<BillVo>>().message("token失效").code(ResponseCode.TokenInvalid).build();

        return new ApiOut.Builder<List<BillVo>>().data(converter.toVos(statementService.findBillListRank(vo.getOpenid(),vo.getPage(),vo.getSize(),vo.getStime(),vo.getEtime()),this::toBillVo)).code(ResponseCode.SUCCESS).build();
    }

    @ApiOperation(value = "频率排行",notes = "频率排行")
    @GetMapping(path = "/getBillFrequency",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<List<BillVo>> getBillListFrequency(BillVo vo, @RequestHeader String token){
        if (!validateToken(token,vo.getOpenid()))
            return new ApiOut.Builder<List<BillVo>>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return new ApiOut.Builder<List<BillVo>>().data(converter.toVos(statementService.findBillListFrequency(vo.getOpenid(),vo.getPage(),vo.getSize(),vo.getStime(),vo.getEtime()),this::toBillVo)).code(ResponseCode.SUCCESS).build();
    }
    @ApiOperation(value = "排行流水详情",notes = "排行流水详情")
    @GetMapping(path = "/getBillInfo",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<List<BillVo>> getBillInfo(@RequestHeader String token,String openid,String redEnvelopeBak){
        if (!validateToken(token,openid))
            return new ApiOut.Builder<List<BillVo>>().message("token失效").code(ResponseCode.TokenInvalid).build();
        return new ApiOut.Builder<List<BillVo>>().data(converter.toVos(statementService.findByRedEnvelopeBak(openid,redEnvelopeBak),this::toBillVo)).code(ResponseCode.SUCCESS).build();
    }

    @ApiOperation(value = "流水添加",notes = "流水添加")
    @PostMapping (path = "/bill",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<BillVo> postBill(BillVo vo){
        return new ApiOut.Builder<BillVo>().data(new BillVo(statementService.insert(vo.toModel()))).code(ResponseCode.SUCCESS).build();
    }
    @ApiOperation(value = "近一个月的收付近况",notes = "近一个月的收付近况")
    @GetMapping(path = "/bill/{openid}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,headers=API_VER)
    public ApiOut<Map<String, Object>> getMoth(@PathVariable String openid, @RequestHeader String token){
        return new ApiOut.Builder<Map<String, Object>>().data(statementService.findMonth(openid)).code(ResponseCode.SUCCESS).build();
    }
    /*---------------------------------private----------------------------------------------------*/
    private BillVo toBillVo(Statement ad){
        return new BillVo(ad);
    }


}
