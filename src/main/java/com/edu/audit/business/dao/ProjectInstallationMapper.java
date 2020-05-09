package com.edu.audit.business.dao;

import com.edu.audit.business.domain.ProjectInstallation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectInstallationMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByProjectId(String projectId);

    int insert(ProjectInstallation record);

    int insertSelective(ProjectInstallation record);

    ProjectInstallation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectInstallation record);

    int updateByPrimaryKey(ProjectInstallation record);
}