package com.bigdata.apiout;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: BaseVo
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Data
public class BaseVo implements Serializable, Cloneable{
    private String sid;
    private Date createTime;
    private Date updateTime;
}
