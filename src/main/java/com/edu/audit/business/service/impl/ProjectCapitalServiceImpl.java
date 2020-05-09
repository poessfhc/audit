package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectCapitalMapper;
import com.edu.audit.business.domain.ProjectCapital;
import com.edu.audit.business.dto.ProjectCapitalDto;
import com.edu.audit.business.service.ProjectCapitalService;
import com.edu.audit.business.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName: ProjectCapitalServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/3 13:47
 * @Version: v1.0
 */
@Service
public class ProjectCapitalServiceImpl implements ProjectCapitalService {
    @Autowired
    ProjectCapitalMapper projectCapitalMapper;
    @Autowired
    ProjectService projectService;

    @Override
    public Integer insertProjectCapital(ProjectCapital projectCapital) {
        projectCapital.setId(UUID.randomUUID().toString());
        projectService.changeStage(projectCapital.getProjectId());
        return projectCapitalMapper.insert(projectCapital);
    }

    @Override
    public ProjectCapitalDto queryProjectCapitalByProjectId(String id) {
        return projectCapitalMapper.queryProjectCapital(id);
    }

    @Override
    public Integer settlementByprojectId(String projectId, Integer finalAmount) {
        return projectCapitalMapper.settlementByprojectId(projectId,finalAmount);
    }
}
