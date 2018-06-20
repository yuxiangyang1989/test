package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: SysPermission
 * @Description:权限信息
 * @date 2018-05-30
 * @version:1.0.0
 */
@Data
public class SysPermission{

    private Long id;
    private String permission;
    private Date updateTime;
    private Date createTime;
}
