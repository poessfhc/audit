package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectMapper;
import com.edu.audit.business.domain.Project;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Identification;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProjectServiceImpl
 * @Description: 工程操作Service实现类
 * @Author: Vince
 * @Date: 2020/2/25 13:43
 * @Version: v1.0
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize, Integer stage) {
        return PageUtils.getPageResult(pageNum, pageSize, getPageInfo(pageNum, pageSize, stage));
    }

    private PageInfo<Project> getPageInfo(Integer pageNum, Integer pageSize, Integer stage) {
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projects = projectMapper.queryProjectListByStagePage(stage);
        return new PageInfo<Project>(projects);
    }
}
