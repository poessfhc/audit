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
     * 工程阶段（1-立项 2-预算 3-拨付 4-结算 5-实施）
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