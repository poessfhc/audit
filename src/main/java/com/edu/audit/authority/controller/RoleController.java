package com.edu.audit.authority.controller;

import com.edu.audit.authority.dao.SysRoleMapper;
import com.edu.audit.authority.dto.RoleMenuDto;
import com.edu.audit.authority.dto.RoleMenuDtos;
import com.edu.audit.authority.service.TreeService;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: RoleController
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 13:01
 * @Version: v1.0
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理")
public class RoleController {
    @Autowired
    TreeService treeService;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    UserService userService;

    @GetMapping("/queryTree")
    @ApiOperation("查询菜单")
    public Result queryTree() {
        Result result = new Result(200, "查询成功");
        result.putData("menuTree", treeService.queryTree());
        return result;
    }

    @GetMapping("/queryRoleList")
    @ApiOperation("查询角色列表")
    public Result queryRoleList() {
        Result result = new Result(200, "查询成功");
        result.putData("roleList", sysRoleMapper.selectAllRole());
        return result;
    }

    @GetMapping("/queryRole")
    @ApiOperation("查询角色列表")
    public Result queryRole() {
        Result result = new Result(200, "查询成功");
        result.putData("roleList", sysRoleMapper.selectRole());
        return result;
    }

    @GetMapping("/queryRoleByUserId")
    @ApiOperation("通过用户id查角色id")
    public Result queryRoleByUserId(@RequestParam String userId) {
        Result result = new Result(200, "查询成功");
        result.putData("roleList", sysRoleMapper.queryRoleByUserId(userId));
        return result;
    }

    @GetMapping("/updateUserRoleByUserId")
    @ApiOperation("通过用户id更新用户角色")
    public Result updateUserRoleByUserId(@RequestParam String remark, @RequestParam String userId) {
        Result result = new Result(200, "更新成功");
        userService.updateUserRoleByUserId(remark,userId);
        return result;
    }

    @GetMapping("/queryRoleTree")
    @ApiOperation("查询角色菜单")
    public Result queryRoleTree(@RequestParam String roleId) {
        Result result = new Result(200, "查询成功");
        result.putData("menuRoleTree", treeService.queryRoleTree(roleId));
        return result;
    }

    @PostMapping("/updateRoleTreeByRoleId")
    @ApiOperation("通过角色id更新角色菜单")
    public Result updateRoleTreeByRoleId(@RequestBody RoleMenuDtos roleMenuDtos) {
        Result result = null;
        Integer flag = treeService.updateRoleTreeByRoleId(roleMenuDtos);
        if (flag.equals(1)) {
            result = new Result(200, "更新成功");
            return result;
        }
        result = new Result(0, "更新失败");
        return result;
    }

}
