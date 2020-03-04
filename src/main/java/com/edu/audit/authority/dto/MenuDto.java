package com.edu.audit.authority.dto;

import com.edu.audit.authority.domain.SysMenu;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: MenuDto
 * @Description: 显示菜单返回集
 * @Author: Vince
 * @Date: 2020/3/1 13:16
 * @Version: v1.0
 */
@Data
public class MenuDto {
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父菜单ID
     */
    private String parentId;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 父菜单下的按钮
     */
    private List<SysMenu> menuControlLists;
}
