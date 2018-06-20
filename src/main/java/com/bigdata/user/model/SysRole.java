package com.bigdata.user.model;

import com.bigdata.enums.user.RoleTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: SysRole
 * @Description: 角色
 * @date 2018-05-30
 * @version:
 */
@Data
public class SysRole{
    private Long id;
    private Date updateTime;
    private Date createTime;
    private RoleTypeEnum role;
}
