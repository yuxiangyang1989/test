package com.bigdata.szb.repository;

import com.bigdata.szb.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yang
 * @ClassName: StatementRepository
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Repository
public interface StatementRepository extends JpaRepository<Statement,Long>,JpaSpecificationExecutor<Statement> {


}
