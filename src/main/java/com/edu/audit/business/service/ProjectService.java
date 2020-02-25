package com.edu.audit.business.service;

import com.edu.audit.business.domain.Project;
import com.edu.audit.utils.PageResult;

import java.util.List;

/**
 * @ClassName: ProjectService
 * @Description: 工程操作Service接口
 * @Author: Vince
 * @Date: 2020/2/25 13:42
 * @Version: v1.0
 */
public interface ProjectService {
    /**
     * 根据工程阶段查询工程列表
     */
    PageResult findPage(Integer pageNum, Integer pageSize, Integer stage);
}
