package com.bigdata.framework.common.utils;

import com.bigdata.exception.SZBException;
import com.github.pagehelper.Page;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yang
 * @ClassName: PaginationEntityConverter
 * @Description:
 * @date 2018-05-29
 * @version:
 */
public class PaginationEntityConverter<M , V > {
    /**
     * 将模 model 转换成 vo
     * @param models 数据库中的实体
     * @param converter 数据转换器
     * @return 根据实体转出来的VO
     */
    public List<V> toVos(List<M> models, Function<M, V> converter) {
        if (null == converter) {
            throw new SZBException("没有传入实体数据转换器！");
        }
        if (CollectionUtils.isEmpty(models)) {
            // throw new SZBException("没有传入需要转换的实体数据！");
            return new ArrayList<V>(0);
        }
        // 根据自定义逻辑对数据进行转换
        List<V> vos = models.stream().map(converter).collect(Collectors.toList());
        // 如果使用了数据库的自动页页，将分页信息复制出来
        if (models instanceof Page) {
            Page page = (Page) models;

            Page<V> pageVos = new Page<V>();
            pageVos.setTotal(page.getTotal());
            pageVos.setPageSize(page.getPageSize());
            pageVos.setPageNum(page.getPageNum());
            pageVos.addAll(vos);
            return pageVos;
        }
        return vos;
    }
    /**
     * 将Repository获取的结果转化为Page对象,一般用于解决不允许联表查询的情况，需要多表的值
     * @param model Repository获取的结果
     * @return  Page对象
     */
    public static Page toPage(List model){
        Page result = new Page();
        if (model instanceof Page) {
            Page page = (Page) model;
            result.setTotal(page.getTotal());
            result.setPageSize(page.getPageSize());
            result.setPageNum(page.getPageNum());
        }
        return result;
    }
}
