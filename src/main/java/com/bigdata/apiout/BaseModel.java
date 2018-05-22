package com.bigdata.apiout;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: BaseModel
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
public class BaseModel implements Serializable{
    private Date updateTime;
    private Date createTime;
}
