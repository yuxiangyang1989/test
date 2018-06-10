package com.bigdata.szb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.szb.model.Statement;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author yang
 * @ClassName: StatementRankVo
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementRankVo extends BaseVo{
    private Long price;
    private String ninkName;
    private String headUrl;
    private String openid;
    private String frequency;
}
