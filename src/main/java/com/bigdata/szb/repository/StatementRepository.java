package com.bigdata.szb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.szb.model.Statement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yang
 * @ClassName: StatementRepository
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Mapper
public interface StatementRepository extends IBaseRepository<Statement,Long>{

    List<Statement> findAll(Statement statement);
    List<Statement> findBillListRank(Statement statement);
    List<Statement> findBillListFrequency(Statement statement);

    Integer findBillGroupByMonth(String openid);

    List<Statement> findBillGroupByProduct(String openid);

    List<Statement> findByRedEnvelopeBak(Statement statement);

    List<Statement> findBillForLine(Statement statement);

    List<Statement> findBillForChart(Statement statement);
}
