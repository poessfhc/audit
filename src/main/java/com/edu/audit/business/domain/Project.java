package com.edu.audit.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    /**
     * 主键
     */
    private String id;
    /**
     * 工程名
     */
    private String projectName;
    /**
     * 工程实施用户id
     */
    private String userId;
    /**
     * 工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施中 10-实施结束）
     */
    private Integer stage;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新人
     */
    private Date updateBy;
    /**
     * 工程描述
     */
    private String description;

}