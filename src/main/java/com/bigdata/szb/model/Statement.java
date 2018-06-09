package com.bigdata.szb.model;

import com.bigdata.apiout.BaseModel;
import com.bigdata.enums.StatementType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yang
 * @ClassName: Statement
 * @Description:对账单
 * @date 2018-05-29
 * @version:
 */
@Data
@Entity
public class Statement extends BaseModel {
    @Id
    private Long id;
    private String userCode;
    private StatementType type;//账单类型
    private String content;//描述
    private String price;//明细
}
