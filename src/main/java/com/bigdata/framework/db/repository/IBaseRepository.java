package com.bigdata.framework.db.repository;

import com.bigdata.framework.db.condition.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @ClassName: IBaseRepository
 * @Description:
 * @date 2018-06-20
 * @version:
 */
public interface IBaseRepository<T, PK>  {
    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 单个实体对象
     */
    T load(PK id);

    /**
     * 根据条件查询第一条数据
     *
     * @param condition 查询条件
     * @param <C>       实际的查询条件对象
     * @return 单个实体对象
     */
    <C extends QueryCondition> T findOne(C condition);

    /**
     * 根据条件查询所有数据, 自动分页
     *
     * @param condition 查询条件
     * @param <C>       实际的查询条件对象
     * @return 满足条件的实体对象.
     */
    <C extends QueryCondition> List<T> find(C condition);


    /**
     * 创建单个或多个对象
     *
     * @param entities 需要新增的实际数据
     * @return 处理成功的行记录数
     */
    @SuppressWarnings("unchecked")
    Integer create(T... entities);

    /**
     * 修改单个对象
     *
     * @param entity 需要修改的实际数据
     * @return 处理成功的行记录数
     */
    Integer update(T entity);

    /**
     * 更新数据状态
     *
     * @param state 状态
     * @param ids   主键
     * @return 处理成功的行记录数
     */
    @SuppressWarnings("unchecked")
    Integer updateState(@Param("state") int state, @Param("ids") PK... ids);
}
