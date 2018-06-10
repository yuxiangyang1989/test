package com.bigdata.szb.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.szb.model.Statement;
import com.bigdata.szb.repository.StatementRepository;
import com.bigdata.szb.service.StatementService;
import com.bigdata.szb.vo.StatementRankVo;
import com.bigdata.user.model.WXUserInfo;
import com.bigdata.user.repository.WXUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private WXUserInfoRepository wxUserInfoRepository;

    @Override
    public List<Statement> findBillList(String openid, Pageable pageable, Date stime, Date etime) throws SZBException {

        Specification<Statement> querySpecifi = new Specification<Statement>(){
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (null != stime) {
                    //大于或等于传入时间
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), stime));
                }
                if (null != etime) {
                    //小于或等于传入时间
                    predicates.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), etime));
                }
                predicates.add(cb.equal(root.get("openid").as(String.class),openid));

                // and到一起的话所有条件就是且关系，or就是或关系
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return statementRepository.findAll(querySpecifi,pageable).stream().collect(Collectors.toList());
    }

    @Override
    public Statement modify(Statement statement) throws SZBException {
        return statementRepository.save(statement);
    }

    @Override
    public List<StatementRankVo> findBillListRank(Date stime, Date etime) throws SZBException {
        Specification<Statement> querySpecifi = new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (null != stime) {
                    //大于或等于传入时间
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), stime));
                }
                if (null != etime) {
                    //小于或等于传入时间
                    predicates.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), etime));
                }
                // and到一起的话所有条件就是且关系，or就是或关系
                criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
                criteriaQuery.multiselect(root.get("openid"),cb.avg(root.get("price")).alias("price"));

                criteriaQuery.orderBy(cb.desc(root.get("price")));
                criteriaQuery.groupBy(root.get("openid"));
                return criteriaQuery.getRestriction();
            }
        };
        List<Statement> list = statementRepository.findAll(querySpecifi).stream().limit(10).collect(Collectors.toList());
        List<StatementRankVo> vos = new ArrayList<StatementRankVo>(list.size());
        for (Statement statement:list){
            WXUserInfo wxUserInfo = wxUserInfoRepository.findByOpenid(statement.getOpenid());
            StatementRankVo vo = new StatementRankVo();
            vo.setOpenid(statement.getOpenid());
            vo.setPrice(statement.getPrice());
            vo.setNinkName(wxUserInfo.getNickname());
            vo.setHeadUrl(wxUserInfo.getHeadimgurl());
            vos.add(vo);
        }


        return vos;
    }

    @Override
    public List<StatementRankVo> findBillListFrequency(Date stime, Date etime) throws SZBException {
        Specification<Statement> querySpecifi = new Specification<Statement>() {
            @Override
            public Predicate toPredicate(Root<Statement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (null != stime) {
                    //大于或等于传入时间
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), stime));
                }
                if (null != etime) {
                    //小于或等于传入时间
                    predicates.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), etime));
                }
                // and到一起的话所有条件就是且关系，or就是或关系
                criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
                criteriaQuery.multiselect(root.get("openid"),cb.count(root.get("openid")).alias("content"));
                criteriaQuery.orderBy(cb.desc(root.get("content")));
                criteriaQuery.groupBy(root.get("openid"));
                return criteriaQuery.getRestriction();
            }
        };

        List<Statement> list = statementRepository.findAll(querySpecifi).stream().limit(10).collect(Collectors.toList());
        List<StatementRankVo> vos = new ArrayList<StatementRankVo>(list.size());
        for (Statement statement:list){
            WXUserInfo wxUserInfo = wxUserInfoRepository.findByOpenid(statement.getOpenid());
            StatementRankVo vo = new StatementRankVo();
            vo.setOpenid(statement.getOpenid());
            vo.setFrequency(statement.getContent());
            vo.setNinkName(wxUserInfo.getNickname());
            vo.setHeadUrl(wxUserInfo.getHeadimgurl());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public Statement insert(Statement statement) throws SZBException {
        return statementRepository.save(statement);
    }
}
