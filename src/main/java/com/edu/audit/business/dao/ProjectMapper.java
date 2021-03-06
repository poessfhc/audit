package com.edu.audit.business.dao;

import com.edu.audit.business.domain.Project;
import com.edu.audit.business.dto.ProjectDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String id);

    int selectByPrimaryKeyCount(String id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> queryProjectListByStageAll(Integer stage);

    /**
     * 根据阶段查询工程列表
     */
    List<Project> queryProjectListByStagePage(Integer stage);

    /**
     * 根据阶段查询工程列表
     */
    List<ProjectDto> queryProjectDtoListByStagePage(Integer stage);

    /**
     * 根据阶段查询待审核工程列表
     */
    List<ProjectDto> queryAuditProjectDtoListByStagePage(Integer stage);

    /**
     * 通过id变更阶段
     */
    int changeStage(String id, Integer stage);

    /**
     * 警告
     * */
    int warning(String id,String flag);

    /**
     * 查询警告
     * */
    String queryflag(String id);
}