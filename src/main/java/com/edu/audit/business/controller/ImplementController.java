package com.edu.audit.business.controller;

import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ImplementController
 * @Description: 工程实施控制层
 * @Author: Vince
 * @Date: 2020/4/15 11:09
 * @Version: v1.0
 */
@Api(value = "工程实施模块")
@RestController
@RequestMapping("/implement")
public class ImplementController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/queryProjectListByStatus")
    @ApiOperation("根据状态查询工程列表")
    public Result queryProjectListByStatus(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", projectService.findPage(pageNum, pageSize, stage));
        return result;
    }

    @GetMapping("/changeProjectStageById")
    @ApiOperation("通过id改变工程阶段")
    public Result changeProjectStageById(@RequestParam String id) {
        Result result = new Result(200, "变更成功");
        result.putData("flag", projectService.changeStage(id));
        return result;
    }


}
