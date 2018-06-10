package com.bigdata.szb.model;

import com.bigdata.enums.szb.StatementType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Statement
 * @Description:对账单
 * @date 2018-05-29
 * @version:
 */
@Data
@Entity
@Table(name = "statement")
public class Statement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    private String openid;
    private StatementType type;//账单类型
    private String content;//描述
    private Long price;//明细
}
