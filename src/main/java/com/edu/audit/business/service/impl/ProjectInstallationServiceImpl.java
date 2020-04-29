package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectInstallationMapper;
import com.edu.audit.business.domain.ProjectInstallation;
import com.edu.audit.business.service.ProjectInstallationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProjectInstallationServiceImpl
 * @Description: 工程设施相关接口
 * @Author: Vince
 * @Date: 2020/4/29 22:17
 * @Version: v1.0
 */
@Service
public class ProjectInstallationServiceImpl implements ProjectInstallationService {
    @Autowired
    ProjectInstallationMapper projectInstallationMapper;

    @Override
    public Integer insertInstallation(List<ProjectInstallation> projectInstallations) {
        projectInstallations.stream().forEach(projectInstallationMapper::insert);
        return 1;
    }
}
