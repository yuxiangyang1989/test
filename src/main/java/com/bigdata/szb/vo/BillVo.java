package com.bigdata.szb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.szb.StatementType;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.szb.model.Statement;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: StatementVo
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillVo extends BaseVo{
    private String openid;
    private StatementType type;//账单类型
    private String content;//描述
    private Long price;//明细
    private Date stime;
    private Date etime;
    private Integer page;
    private Integer size;

    public BillVo(){}

    public BillVo(Statement statement){
        Optional.ofNullable(statement.getId()).ifPresent(id ->this.setSid(NumberUtils.compress(id)));
        this.setOpenid(statement.getOpenid());
        this.setType(statement.getType());
        this.setContent(statement.getContent());
        this.setPrice(statement.getPrice());
    }

    public Statement toModel(){
        Statement statement = new Statement();
        statement.setId(NumberUtils.uncompress(this.getSid()));
        statement.setContent(this.getContent());
        statement.setUpdateTime(new Date());
        return statement;
    }
}
