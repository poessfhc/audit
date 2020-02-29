package com.edu.audit.business.service;

import com.edu.audit.business.dto.InstallationDto;
import com.edu.audit.utils.PageResult;

import java.util.List;

/**
 * @ClassName: InstallationService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/29 18:17
 * @Version: v1.0
 */
public interface InstallationService {
    /**
     * 根据工程阶段查询工程列表
     *
     * @param pageNum  当前页面
     * @param pageSize 页面大小
     * @return 分页后的设施详细数据
     */
    PageResult queryInstallationList(Integer pageNum, Integer pageSize);
}
