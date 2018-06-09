package com.bigdata.user.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: SysPermission
 * @Description:权限信息
 * @date 2018-05-30
 * @version:1.0.0
 */
@Data
@Entity
@Table(name="sys_permission")
public class SysPermission{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permission;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
}
