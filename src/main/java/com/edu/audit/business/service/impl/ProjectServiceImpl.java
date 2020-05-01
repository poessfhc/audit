package com.edu.audit.business.service.impl;

import com.edu.audit.authority.dao.SysUserMapper;
import com.edu.audit.business.dao.ProjectAuditMapper;
import com.edu.audit.business.dao.ProjectCapitalMapper;
import com.edu.audit.business.dao.ProjectMapper;
import com.edu.audit.business.domain.Project;
import com.edu.audit.business.domain.ProjectAudit;
import com.edu.audit.business.dto.ProjectCapitalDto;
import com.edu.audit.business.dto.ProjectDto;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Identification;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
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
    @Autowired
    ProjectAuditMapper projectAuditMapper;
    @Autowired
    SysUserMapper sysUserMapper;

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
        String userId = sysUserMapper.queryUserIdByUsername(project.getUserId());
        project.setUserId(userId);
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
        String auditName = null;
        if (stage.equals(Identification.Project.LIXIANG)) {
            afterStage = Identification.Project.LIXIANGZHONG;
        }
        if (stage.equals(Identification.Project.LIXIANGZHONG)) {
            afterStage = Identification.Project.YUSUAN;
            auditName = Identification.AuditName.LIXIANGSHENHE;
        }
        if (stage.equals(Identification.Project.YUSUAN)) {
            afterStage = Identification.Project.YUSUANZHONG;
        }
        if (stage.equals(Identification.Project.YUSUANZHONG)) {
            afterStage = Identification.Project.BOFU;
            auditName = Identification.AuditName.YUSUANSHENHE;
        }
        if (stage.equals(Identification.Project.BOFU)) {
            afterStage = Identification.Project.BOFUZHONG;
        }
        if (stage.equals(Identification.Project.BOFUZHONG)) {
            afterStage = Identification.Project.SHISHI;
            auditName = Identification.AuditName.BOFUSHENHE;
        }
        if (stage.equals(Identification.Project.SHISHI)) {
            afterStage = Identification.Project.SHISHIJIESHU;
        }
        if (stage.equals(Identification.Project.SHISHIJIESHU)) {
            afterStage = Identification.Project.JIESUAN;
            auditName = Identification.AuditName.SHISHISHENHE;
        }
        if (stage.equals(Identification.Project.JIESUAN)) {
            afterStage = Identification.Project.JIESUANZHONG;
        }
        if (stage.equals(Identification.Project.JIESUANZHONG)) {
            afterStage = Identification.Project.END;
            auditName = Identification.AuditName.JIESUANSHENHE;
        }
        if (afterStage.equals(-1)) {
            return 0;
        }
        if (auditName != null) {
            Integer flag = projectMapper.changeStage(id, afterStage);
            ProjectAudit projectAudit = new ProjectAudit(UUID.randomUUID().toString(), auditName, stage, flag.byteValue(), id, SecurityUtils.getSubject().getPrincipal().toString());
            projectAuditMapper.insert(projectAudit);
            return flag;
        }
        Integer flag = projectMapper.changeStage(id, afterStage);
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
