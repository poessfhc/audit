package com.edu.audit.business.service;

import com.edu.audit.business.domain.ProjectInstallation;

import java.util.List;

/**
 * @ClassName: ProjectInstallationService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/29 22:17
 * @Version: v1.0
 */
public interface ProjectInstallationService {
    Integer insertInstallation(List<ProjectInstallation> projectInstallations);
}
