package com.bigdata.user.repository;

import com.bigdata.user.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: SysRoleRepository
 * @Description:
 * @date 2018-06-03
 * @version:1.0.0
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole,Long>{
}
