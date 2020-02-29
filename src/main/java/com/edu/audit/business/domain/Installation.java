package com.edu.audit.business.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Installation {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 设施名字
     */
    private String installationName;
    /**
     * 设施价格（元/平方米）
     */
    private BigDecimal price;
    /**
     * 设施描述
     */
    private String description;
}