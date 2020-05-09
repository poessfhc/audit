package com.edu.audit.business.service;

import com.edu.audit.business.domain.Project;
import com.edu.audit.business.dto.ProjectCapitalDto;
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
     *
     * @param pageNum  当前页面
     * @param pageSize 页面大小
     * @param stage    工程阶段
     * @return 分页后的工程详细数据
     */
    PageResult findPage(Integer pageNum, Integer pageSize, Integer stage);

    /**
     * 根据工程阶段查询待审核工程列表
     *
     * @param pageNum  当前页面
     * @param pageSize 页面大小
     * @param stage    工程阶段
     * @return 分页后的待审核工程详细数据
     */
    PageResult findAuditPage(Integer pageNum, Integer pageSize, Integer stage);

    /**
     * 发布工程
     *
     * @param project 工程信息
     * @return 返回是否插入成功
     */
    int insertProject(Project project);

    /**
     * 通过id查询工程信息
     *
     * @param id 主键
     * @return 工程信息
     */
    Project queryProjectById(String id);

    /**
     * 通过id改变工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施 10-实施结束）
     *
     * @param id 主键
     * @return 返回是否成功 0-失败 1-成功
     */
    int changeStage(String id);

    /**
     * 拒绝操作
     * */
    int downStage(String id);

    /**
     * 立项
     *
     * @param project 申请工程详细信息
     * @return 返回是否成功 0-失败 1-成功
     */
    int listItems(Project project);

    /**
     * 通过主键查询查询工程信息和资金列表
     *
     * @param id 主键
     * @return 工程信息和资金列表的集合数据
     */
    ProjectCapitalDto queryProjectCapital(String id);
}
