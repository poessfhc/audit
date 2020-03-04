package com.edu.audit.business.dao;

import com.edu.audit.business.domain.Installation;
import com.edu.audit.business.dto.InstallationDto;
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
}