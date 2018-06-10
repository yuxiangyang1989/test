package com.bigdata.szb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.szb.model.Statement;
import com.bigdata.szb.vo.StatementRankVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * @author yang
 * @ClassName: StatementService
 * @Description:
 * @date 2018-06-10
 * @version:
 */
public interface StatementService {
    /**
     * 获取流水
     * @param openid
     * @param pageable
     * @return
     */
    List<Statement> findBillList(String openid, Pageable pageable,Date stime, Date etime) throws SZBException;

    /**
     * 修改昵称、产品名
     * @param statement
     * @return
     */
    Statement modify(Statement statement) throws SZBException;

    /**
     * 获取前十排行
     * @return
     */
    List<StatementRankVo> findBillListRank(Date stime, Date etime) throws SZBException;

    /**
     * 获取前十的活动率排行
     * @return
     */
    List<StatementRankVo> findBillListFrequency(Date stime, Date etime) throws SZBException;

    Statement insert(Statement statement) throws SZBException;
}
