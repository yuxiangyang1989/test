package com.bigdata.user.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.SysRole;
import com.bigdata.user.model.UserInfo;
import com.bigdata.user.repository.SysRoleRepository;
import com.bigdata.user.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @ClassName: SysRoleServiceImpl
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Slf4j
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleRepository sysRoleRepository;

    public List<SysRole> selectRoleByUser(UserInfo userInfo) throws SZBException{
        SysRole sysRole = new SysRole();
        sysRole.setId(userInfo.getRoleId());
        //Example<SysRole> example = Example.of(sysRole);
        return null;
    }

}
