package com.edu.audit.business.dao;

import com.edu.audit.business.domain.Installation;
import com.edu.audit.business.domain.InstallationStep;
import com.edu.audit.business.dto.InstallationDto;
import com.edu.audit.business.dto.SingleInstallation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface InstallationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Installation record);

    int insertSelective(Installation record);

    List<InstallationDto> selectInstallationList();

    Installation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Installation record);

    int updateByPrimaryKey(Installation record);

    int updatePriceById(BigDecimal price, Integer id);

    List<SingleInstallation> queryInstallationCountById(String id);

    List<InstallationStep> queryInstallationByProjectId(String projectId);

    Integer queryNewStep(String projectId);

    int updateInstallationFlagByProjectId(String projectId, Integer installationId, String stepFlag);
}