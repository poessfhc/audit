package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: RoleMenuDtos
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 20:05
 * @Version: v1.0
 */
@Data
@ApiModel("变更角色菜单映射")
public class RoleMenuDtos {
    private String roleId;
    private List<RoleMenuDto> roleMenuDto;
}
