package com.bigdata.szb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.szb.StatementType;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.szb.model.Statement;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
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
    private String nikeName;
    private String redEnvelope;
    private Long frequency;
    private Date createDate;
    private Date stime;
    private Date etime;
    @NotEmpty
    private Integer page;
    @NotEmpty
    private Integer size;

    public BillVo(){}

    public BillVo(Statement statement){
        Optional.ofNullable(statement.getId()).ifPresent(id ->this.setSid(NumberUtils.compress(id)));
        this.setOpenid(statement.getOpenid());
        this.setType(statement.getType());
        this.setContent(statement.getContent());
        this.setNikeName(statement.getNikeName());
        this.setRedEnvelope(statement.getRedEnvelopeBak());
        this.setPrice(statement.getAmount());
        this.setCreateDate(statement.getCreateTime());
        this.setFrequency(statement.getFrequency());
    }

    public Statement toModel(){
        Statement statement = new Statement();
        Optional.ofNullable(this.getSid()).ifPresent(sid->statement.setId(NumberUtils.uncompress(sid)));
        statement.setContent(this.getContent());
        statement.setRedEnvelope(this.getRedEnvelope());
        statement.setRedEnvelopeBak(this.getRedEnvelope());
        statement.setAmount(this.getPrice());
        statement.setOpenid(this.getOpenid());
        statement.setType(this.getType());
        statement.setNikeName(this.getNikeName());
        statement.setUpdateTime(new Date());
        return statement;
    }
}
