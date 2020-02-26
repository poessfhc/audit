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

    /**
     * 通过id改变工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施 10-实施结束）
     *
     * @param id 主键
     * @return 返回是否成功 0-失败 1-成功
     */
    int changeStage(String id);
}
