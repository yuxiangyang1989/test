package com.bigdata.user.model;

import com.bigdata.enums.user.RoleTypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: SysRole
 * @Description: 角色
 * @date 2018-05-30
 * @version:
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    private RoleTypeEnum role;
}
