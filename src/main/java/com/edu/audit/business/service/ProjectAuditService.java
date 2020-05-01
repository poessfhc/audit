package com.edu.audit.business.service;

import com.edu.audit.business.domain.ProjectAudit;

import java.util.List;

/**
 * @ClassName: ProjectAuditService
 * @Description: 工程审核记录服务层
 * @Author: Vince
 * @Date: 2020/5/1 13:32
 * @Version: v1.0
 */
public interface ProjectAuditService {
    /**
     * 通过id查询工程审核记录
     * @param projectId 工程id
     * @return 审核列表
     * */
    List<ProjectAudit> queryProjectAuditByProjectId(String projectId);
}
