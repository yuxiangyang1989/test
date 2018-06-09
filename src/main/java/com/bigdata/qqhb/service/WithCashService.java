package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.RedBag;
import com.bigdata.qqhb.model.Withcash;
import com.bigdata.qqhb.model.Withdrawals;

import java.util.List;

/**
 * @author yang
 * @ClassName: WithCashService
 * @Description:每日红包
 * @date 2018-05-27
 * @version:
 */
public interface WithCashService {
    /**
     * 客户获得每日红包
     * @param withdrawals
     * @return boolean
     * @throws Exception
     */
    public boolean add(Withdrawals withdrawals) throws Exception;
    /**
     * 插入余额
     * @param withcash
     * @return boolean
     * @throws Exception
     */
    public boolean addBalance(Withcash withcash) throws Exception;
    /**
     * 提现余额修改
     * @param withcash
     * @return boolean
     * @throws Exception
     */
    public boolean modifyBalance(Withcash withcash) throws SZBException;
    /**
     * 根据客户查询余额
     * @param userCode
     * @return Withdrawals
     * @throws Exception
     */
    public List<Withcash> findBalanceByUserCode(String userCode) throws SZBException;
    /**
     * 查询红包基数
     * @param redbagId
     * @return List<RedbagVo>
     * @throws Exception
     */
    public List<RedBag> findRedBag(String redbagId) throws SZBException;
}
