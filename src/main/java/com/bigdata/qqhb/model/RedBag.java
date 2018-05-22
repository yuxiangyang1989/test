package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @ClassName: RedBag
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class RedBag extends BaseModel implements Serializable{
    @Id
    private String redbagId;
    private String redbag;
}
