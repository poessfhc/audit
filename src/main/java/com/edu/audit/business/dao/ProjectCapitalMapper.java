package com.edu.audit.business.dao;

import com.edu.audit.business.domain.ProjectCapital;
import com.edu.audit.business.dto.ProjectCapitalDto;
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

    /**
     * 通过主键查询查询工程信息和资金列表
     *
     * @param id 主键
     */
    ProjectCapitalDto queryProjectCapital(String id);
}