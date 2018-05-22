package com.bigdata.qqhb.model;

import com.bigdata.apiout.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Withdrawals
 * @Description:
 * @date 2018-05-22
 * @version:
 */
@Data
@Entity
public class Withdrawals extends BaseModel implements Serializable {
    @Id
    private String userCode;
    private String cash;
    private Date getdate;
}
