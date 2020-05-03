package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectCapitalMapper;
import com.edu.audit.business.domain.ProjectCapital;
import com.edu.audit.business.service.ProjectCapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Integer insertProjectCapital(ProjectCapital projectCapital) {
        return projectCapitalMapper.insert(projectCapital);
    }
}
