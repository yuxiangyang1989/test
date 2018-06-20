package com.bigdata.framework.sends;

import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: Msg
 * @Description:
 * @date 2018-06-17
 * @version:
 */
@Data
public class Msg {
    private String ext;
    private String extend;
    private String msg;
    private String sig;
    private Telphome tel;
    private Long time;
    private Integer type;
}
