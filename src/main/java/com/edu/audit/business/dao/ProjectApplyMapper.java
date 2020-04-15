package com.edu.audit.business.dao;

import com.edu.audit.business.domain.ProjectApply;

public interface ProjectApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectApply record);

    int insertSelective(ProjectApply record);

    ProjectApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectApply record);

    int updateByPrimaryKey(ProjectApply record);
}