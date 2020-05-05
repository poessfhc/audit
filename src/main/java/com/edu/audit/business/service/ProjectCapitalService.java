package com.edu.audit.business.service;

import com.edu.audit.business.domain.ProjectCapital;
import com.edu.audit.business.dto.ProjectCapitalDto;

/**
 * @ClassName: ProjectCapitalService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/3 13:47
 * @Version: v1.0
 */
public interface ProjectCapitalService {
    /**
     * 插入工程预算金额
     * @param projectCapital 工程预算金额
     * @return 1-成功 0-失败
     * */
    Integer insertProjectCapital(ProjectCapital projectCapital);

    /**
     * 通过工程id查询查询工程信息和资金列表
     * @param id 工程id
     * @return 预算详细（联表）
     * */
    ProjectCapitalDto queryProjectCapitalByProjectId(String id);
}
