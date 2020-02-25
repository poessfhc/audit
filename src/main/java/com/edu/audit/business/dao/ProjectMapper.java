package com.edu.audit.business.dao;

import com.edu.audit.business.domain.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> queryProjectListByStageAll(Integer stage);

    List<Project> queryProjectListByStagePage(Integer stage);
}