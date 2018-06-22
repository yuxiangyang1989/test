package com.bigdata.szb.service.impl;

import com.bigdata.enums.szb.ProductType;
import com.bigdata.exception.SZBException;
import com.bigdata.framework.pager.PageInfo;
import com.bigdata.szb.model.AnalysisDao;
import com.bigdata.szb.model.Statement;
import com.bigdata.szb.repository.StatementRepository;
import com.bigdata.szb.service.StatementService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * @ClassName: StatementServiceImpl
 * @Description:
 * @date 2018-06-10
 * @version:
 */
@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Override
    public List<Statement> findBillList(String openid,Integer page,Integer size, Date stime, Date etime) throws SZBException {
        Statement statement = new Statement();
        statement.setOpenid(openid);
        statement.setStime(stime);
        statement.setEtime(etime);
        PageHelper.startPage(page,size);
        List<Statement> all = statementRepository.findAll(statement);
        PageInfo<Statement> pageInfo = new PageInfo<Statement>(all);
        return pageInfo.getList();
    }

    @Override
    public Statement modify(Statement statement) throws SZBException {
        if (statementRepository.update(statement)>0)
            return statement;
        return null;
    }

    @Override
    public List<Statement> findBillListRank(String openid,Integer page,Integer size,Date stime, Date etime) throws SZBException {
        Statement statement = new Statement();
        statement.setOpenid(openid);
        statement.setStime(stime);
        statement.setEtime(etime);
        PageHelper.startPage(page,size);
        List<Statement> all = statementRepository.findBillListRank(statement);
        PageInfo<Statement> pageInfo = new PageInfo<Statement>(all);
        return pageInfo.getList();
    }

    @Override
    public List<Statement> findBillListFrequency(String openid,Integer page,Integer size,Date stime, Date etime) throws SZBException {
        Statement statement = new Statement();
        statement.setOpenid(openid);
        statement.setStime(stime);
        statement.setEtime(etime);
        PageHelper.startPage(page,size);
        List<Statement> all = statementRepository.findBillListFrequency(statement);
        PageInfo<Statement> pageInfo = new PageInfo<Statement>(all);
        return pageInfo.getList();
    }

    @Override
    public Statement insert(Statement statement) throws SZBException {
        if (statementRepository.create(statement)>0)
            return statement;
        return null;
    }

    @Override
    public Map<String, Object> findMonth(String openid) throws SZBException {
        Map<String ,Object> map = new HashMap<String ,Object>();
        Integer total = statementRepository.findBillGroupByMonth(openid);
        map.put("total",total);
        List<Statement> list = statementRepository.findBillGroupByProduct(openid);
        Map<ProductType,Long> integerMap = new HashMap<ProductType, Long>();
        list.stream().forEach(statement -> {
            integerMap.put(statement.getProductType(),statement.getAmount());
        });
        map.put("product",integerMap);
        return map;
    }

    @Override
    public List<Statement> findByRedEnvelopeBak(String openid,String redEnvelopeBak) throws SZBException {
        Statement statement = new Statement();
        statement.setOpenid(openid);
        statement.setRedEnvelopeBak(redEnvelopeBak);
        return statementRepository.findByRedEnvelopeBak(statement);
    }

    @Override
    public AnalysisDao findAnalysis(String openid, Date sDate, Date eDate) {
        Statement statement = new Statement();
        AnalysisDao dao = new AnalysisDao();
        statement.setOpenid(openid);
        statement.setStime(sDate);
        statement.setEtime(eDate);
        dao.setLine(statementRepository.findBillForLine(statement));
        dao.setChart(statementRepository.findBillForChart(statement));
        return dao;
    }
}
