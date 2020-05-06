package com.edu.audit.business.controller;

import com.edu.audit.business.domain.Project;
import com.edu.audit.business.service.InstallationService;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private InstallationService installationService;

    @PostMapping("/insertProject")
    @ApiOperation("发布工程")
    public Result insertProject(@RequestBody Project project) {
        Integer flag = projectService.insertProject(project);
        Result result;
        if (flag.equals(1)) {
            result = new Result(200, "发布成功");
            return result;
        }
        result = new Result(-1, "发布失败");
        return result;
    }

    @GetMapping("/queryProjectListByStatus")
    @ApiOperation("根据状态查询工程列表")
    public Result queryProjectListByStatus(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", projectService.findPage(pageNum, pageSize, stage));
        return result;
    }

    @GetMapping("/queryAuditProjectListByStatus")
    @ApiOperation("根据状态查询工程列表")
    public Result queryAuditProjectListByStatus(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", projectService.findAuditPage(pageNum, pageSize, stage));
        return result;
    }

    @GetMapping("/queryProjectById")
    @ApiOperation("通过id查询工程信息")
    public Result queryProjectById(@RequestParam String id) {
        Result result = new Result(200, "查询成功");
        result.putData("project", projectService.queryProjectById(id));
        return result;
    }

    @GetMapping("/changeProjectStageById")
    @ApiOperation("通过id改变工程阶段")
    public Result changeProjectStageById(@RequestParam String id) {
        Result result = new Result(200, "变更成功");
        result.putData("flag", projectService.changeStage(id));
        return result;
    }

    @GetMapping("/queryInstallationByProjectId")
    @ApiOperation("通过工程id查询施工列表")
    public Result queryInstallationByProjectId(@RequestParam String projectId) {
        Result result = new Result(200, "查询成功");
        result.putData("items", installationService.queryInstallationByProjectId(projectId));
        result.putData("max", installationService.queryNewStep(projectId));
        return result;
    }

    @GetMapping("/updateInstallationFlagByProjectId")
    @ApiOperation("通过工程id更新设施完成进度")
    public Result updateInstallationFlagByProjectId(@RequestParam String projectId, @RequestParam Integer installationId, @RequestParam String stepFlag) {
        Result result = new Result(200, "更新成功");
        result.putData("flag", installationService.updateInstallationFlagByProjectId(projectId, installationId, stepFlag));
        return result;
    }

}
