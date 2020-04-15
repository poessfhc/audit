package com.edu.audit.authority.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: RouterData
 * @Description: 前端路由数据
 * @Author: Vince
 * @Date: 2020/4/11 15:14
 * @Version: v1.0
 */
@Data
public class RouterData {
    private String component = "dashboard";
    private String name = "dashboard";
    private String path = "/";
    private List<RouterDataItem> children;
}
