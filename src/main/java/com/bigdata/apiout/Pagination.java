package com.bigdata.apiout;


import com.bigdata.framework.common.utils.NumberUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author yang
 * @ClassName: Pagination
 * @Description:
 * @date 2018-05-28
 * @version:
 */
public class Pagination {
    private Integer totalRow;  // 数据量
    private Integer pageSize;  // 每页最多显示多少条数据
    private Integer pageIndex; // 当前页码
    private Integer pageCount; // 总页数
    public Pagination(Integer totalRow, Integer pageSize, Integer pageIndex) {
        this.totalRow = totalRow;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        if (NumberUtils.isPositive(totalRow) && NumberUtils.isPositive(pageSize)) {
            this.pageCount = (int) (Math.ceil(1.0 * totalRow / pageSize));
        }

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
