package com.bigdata.szb.model;

import com.bigdata.enums.szb.AdTypeEnum;
import com.bigdata.szb.enumconvert.AdTypeEnumConvert;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yang
 * @ClassName: Ad
 * @Description:广告
 * @date 2018-06-09
 * @version:
 */
@Data
@Entity
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="create_time")
    private Date createTime;
    private String url;
    @Column(name="ad_url")
    private String adUrl;
    @Convert(converter = AdTypeEnumConvert.class)
    private AdTypeEnum validity;
    @Convert(converter = AdTypeEnumConvert.class)
    private AdTypeEnum type;
    private Integer priority;
}
