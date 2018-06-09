package com.bigdata.qqhb.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yang
 * @ClassName: AccountVo
 * @Description:
 * @date 2018-05-27
 * @version:
 */
@Data
public class AccountVo {
    @NotEmpty(message = "用户信息不能为空")
    private String userCode;
}
