package com.bigdata.szb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.szb.model.Statement;
import com.bigdata.szb.vo.StatementRankVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * @param stime
     * @param etime
     * @return
     * @throws SZBException
     */
    List<Statement> findBillList(String openid,Integer page,Integer size,Date stime, Date etime) throws SZBException;

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
    List<Statement> findBillListRank(String openid,Integer page,Integer size,Date stime, Date etime) throws SZBException;

    /**
     * 获取前十的活动率排行
     * @return
     */
    List<Statement> findBillListFrequency(String openid,Integer page,Integer size,Date stime, Date etime) throws SZBException;

    /**
     * 收账宝获取用户数据
     * @param statement
     * @return
     * @throws SZBException
     */
    Statement insert(Statement statement) throws SZBException;

    /**
     * 近一月收付情况
     * @param openid
     * @return
     * @throws SZBException
     */
    Map<String, Object> findMonth(String openid) throws SZBException;

    List<Statement> findByRedEnvelopeBak(String openid,String redEnvelopeBak) throws SZBException;
}
