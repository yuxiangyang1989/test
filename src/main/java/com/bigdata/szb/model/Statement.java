package com.bigdata.szb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.szb.ProductType;
import com.bigdata.enums.szb.StatementType;
import lombok.Data;

import java.util.Date;


/**
 * @author yang
 * @ClassName: Statement
 * @Description:对账单
 * @date 2018-05-29
 * @version:
 */
@Data
public class Statement extends BaseModel{

    private String content;//描述
    private Long amount;//明细
    private StatementType type;//账单类型
    private ProductType productType;
    private String openid;
    private String nikeName;
    private String redEnvelope;
    private String redEnvelopeBak;
    private Long frequency;
    private Date stime;
    private Date etime;
}
