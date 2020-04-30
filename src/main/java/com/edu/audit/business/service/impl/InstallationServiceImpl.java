package com.edu.audit.business.service.impl;

import com.edu.audit.business.dao.InstallationMapper;
import com.edu.audit.business.dao.ProjectMapper;
import com.edu.audit.business.dto.InstallationCountDto;
import com.edu.audit.business.dto.InstallationDto;
import com.edu.audit.business.dto.SingleInstallation;
import com.edu.audit.business.service.InstallationService;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: InstallationServiceImpl
 * @Description: 工程具体设施实现
 * @Author: Vince
 * @Date: 2020/2/29 18:17
 * @Version: v1.0
 */
@Service
public class InstallationServiceImpl implements InstallationService {
    @Autowired
    InstallationMapper installationMapper;
    @Autowired
    ProjectMapper projectMapper;

    private PageInfo<InstallationDto> getPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InstallationDto> projects = installationMapper.selectInstallationList();
        return new PageInfo<InstallationDto>(projects);
    }

    @Override
    public PageResult queryInstallationList(Integer pageNum, Integer pageSize) {
        return PageUtils.getPageResult(pageNum, pageSize, getPageInfo(pageNum, pageSize));
    }

    @Override
    public int updatePriceById(BigDecimal price, Integer id) {
        return installationMapper.updatePriceById(price, id);
    }

    @Override
    public InstallationCountDto queryInstallationCountById(String id) {
        InstallationCountDto installationCountDto = new InstallationCountDto();
        installationCountDto.setProjectName(projectMapper.selectByPrimaryKey(id).getProjectName());
        List<SingleInstallation> singleInstallations = installationMapper.queryInstallationCountById(id);
        installationCountDto.setInstallations(singleInstallations);
        //todo
        BigDecimal totalPrice = new BigDecimal("0");
        singleInstallations.stream().forEach(singleInstallation -> {
            totalPrice.add(singleInstallation.getTotal());
        });
        installationCountDto.setTotalPrice(totalPrice);
        return installationCountDto;
    }
}
