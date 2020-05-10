package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: MenuTree
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 13:41
 * @Version: v1.0
 */
@Data
@ApiModel("菜单树")
public class MenuTree {
    private String id;
    private String label;
    private List<MenuNode> children;
}
