package com.edu.audit.business.dao;

import com.edu.audit.business.domain.ProjectAudit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectAudit record);

    int insertSelective(ProjectAudit record);

    ProjectAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectAudit record);

    int updateByPrimaryKey(ProjectAudit record);

    List<ProjectAudit> queryProjectAuditByProjectId(String projectId);
}