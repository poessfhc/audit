package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectAuditMapper;
import com.edu.audit.business.domain.ProjectAudit;
import com.edu.audit.business.service.ProjectAuditService;
import com.edu.audit.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProjectAuditServiceImpl
 * @Description: 工程审核记录服务实现类
 * @Author: Vince
 * @Date: 2020/5/1 13:32
 * @Version: v1.0
 */
@Service
public class ProjectAuditServiceImpl implements ProjectAuditService {
    @Autowired
    ProjectAuditMapper projectAuditMapper;

    @Override
    public List<ProjectAudit> queryProjectAuditByProjectId(String projectId) {
        return projectAuditMapper.queryProjectAuditByProjectId(projectId);
    }
}
