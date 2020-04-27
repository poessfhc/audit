package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.ProjectCapitalMapper;
import com.edu.audit.business.dao.ProjectMapper;
import com.edu.audit.business.domain.Project;
import com.edu.audit.business.dto.ProjectCapitalDto;
import com.edu.audit.business.dto.ProjectDto;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Identification;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    ProjectCapitalMapper projectCapitalMapper;

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize, Integer stage) {
        return PageUtils.getPageResult(pageNum, pageSize, getPageInfo(pageNum, pageSize, stage));
    }

    @Override
    public PageResult findAuditPage(Integer pageNum, Integer pageSize, Integer stage) {
        return PageUtils.getPageResult(pageNum, pageSize, getAuditPageInfo(pageNum, pageSize, stage));
    }

    @Override
    public int insertProject(Project project) {
        project.setId(UUID.randomUUID().toString());
        project.setStage(Identification.Project.LIXIANGZHONG);
        return projectMapper.insert(project);
    }

    @Override
    public Project queryProjectById(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int changeStage(String id) {
        Integer count = projectMapper.selectByPrimaryKeyCount(id);
        Integer stage = null;
        if (count != 0) {
            stage = projectMapper.selectByPrimaryKey(id).getStage();
        } else {
            try {
                throw new Exception("异常id");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return 0;
            }
        }
        Integer afterStage = -1;
        //TODO 大概改成switch比较好吧
        if (stage.equals(Identification.Project.LIXIANG)) {
            afterStage = Identification.Project.LIXIANGZHONG;
        }
        if (stage.equals(Identification.Project.LIXIANGZHONG)) {
            afterStage = Identification.Project.YUSUAN;
        }
        if (stage.equals(Identification.Project.YUSUAN)) {
            afterStage = Identification.Project.YUSUANZHONG;
        }
        if (stage.equals(Identification.Project.YUSUANZHONG)) {
            afterStage = Identification.Project.BOFU;
        }
        if (stage.equals(Identification.Project.BOFU)) {
            afterStage = Identification.Project.BOFUZHONG;
        }
        if (stage.equals(Identification.Project.BOFUZHONG)) {
            afterStage = Identification.Project.SHISHI;
        }
        if (stage.equals(Identification.Project.SHISHI)) {
            afterStage = Identification.Project.SHISHIJIESHU;
        }
        if (stage.equals(Identification.Project.SHISHIJIESHU)) {
            afterStage = Identification.Project.JIESUAN;
        }
        if (stage.equals(Identification.Project.JIESUAN)) {
            afterStage = Identification.Project.JIESUANZHONG;
        }
        if (afterStage.equals(-1)) {
            return 0;
        }
        int flag = projectMapper.changeStage(id, afterStage);
        return flag;
    }

    @Override
    public int listItems(Project project) {
        project.setStage(Identification.Project.LIXIANG);
        int flag = projectMapper.insert(project);
        return flag;
    }

    @Override
    public ProjectCapitalDto queryProjectCapital(String id) {
        return projectCapitalMapper.queryProjectCapital(id);
    }

    private PageInfo<ProjectDto> getPageInfo(Integer pageNum, Integer pageSize, Integer stage) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectDto> projects = projectMapper.queryProjectDtoListByStagePage(stage);
        return new PageInfo<ProjectDto>(projects);
    }

    private PageInfo<ProjectDto> getAuditPageInfo(Integer pageNum, Integer pageSize, Integer stage) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectDto> projects = projectMapper.queryAuditProjectDtoListByStagePage(stage);
        return new PageInfo<ProjectDto>(projects);
    }
}
