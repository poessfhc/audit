package com.edu.audit.business.dao;

import com.edu.audit.business.domain.ProjectCapital;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProjectCapitalMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectCapital record);

    int insertSelective(ProjectCapital record);

    ProjectCapital selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectCapital record);

    int updateByPrimaryKey(ProjectCapital record);
}