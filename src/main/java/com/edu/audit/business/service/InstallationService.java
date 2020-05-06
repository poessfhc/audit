package com.edu.audit.business.service;

import com.edu.audit.business.domain.InstallationStep;
import com.edu.audit.business.dto.InstallationCountDto;
import com.edu.audit.business.dto.InstallationDto;
import com.edu.audit.utils.PageResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: InstallationService
 * @Description: 工程具体设施
 * @Author: Vince
 * @Date: 2020/2/29 18:17
 * @Version: v1.0
 */
public interface InstallationService {
    /**
     * 查询材料列表
     *
     * @param pageNum  当前页面
     * @param pageSize 页面大小
     * @return 分页后的设施详细数据
     */
    PageResult queryInstallationList(Integer pageNum, Integer pageSize);

    /**
     * 更新材料价格
     *
     * @param price 设施价格
     * @param id    主键
     * @return 1-成功 0-失败
     */
    int updatePriceById(BigDecimal price, Integer id);

    /**
     * 查询预算列表
     */
    InstallationCountDto queryInstallationCountById(String id);

    /**
     * 通过工程id查询施工列表
     */
    List<InstallationStep> queryInstallationByProjectId(String projectId);

    /**
     * 通过工程id查询最新进度
     */
    Integer queryNewStep(String projectId);

    /**
     * 通过工程id更新设施完成进度
     */
    Integer updateInstallationFlagByProjectId(String projectId, Integer installationId, String stepFlag);
}
