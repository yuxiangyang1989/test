package com.bigdata.szb.model;

import lombok.Data;

import java.util.List;

/**
 * @author yang
 * @ClassName: AnalysisDao
 * @Description:
 * @date 2018-06-23
 * @version:
 */
@Data
public class AnalysisDao {
    private List<Statement> line;
    private List<Statement> chart;
}
