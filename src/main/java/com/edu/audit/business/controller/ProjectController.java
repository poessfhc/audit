package com.edu.audit.business.controller;

import com.edu.audit.business.domain.ProjectCapital;
import com.edu.audit.business.domain.ProjectInstallation;
import com.edu.audit.business.dto.InstallationCountDto;
import com.edu.audit.business.service.*;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ProjectController
 * @Description: 总体工程模块
 * @Author: Vince
 * @Date: 2020/4/29 20:04
 * @Version: v1.0
 */
@Api(value = "总体工程模块")
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectInstallationService projectInstallationService;
    @Autowired
    InstallationService installationService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectAuditService projectAuditService;
    @Autowired
    ProjectCapitalService projectCapitalService;

    @GetMapping("queryProjectAuditByProjectId")
    @ApiOperation("通过工程id查询审核记录")
    public Result queryProjectAuditByProjectId(@RequestParam String projectId) {
        Result result = new Result(200, "查询成功");
        result.putData("auditInfo", projectAuditService.queryProjectAuditByProjectId(projectId));
        return result;
    }


    @PostMapping("/insertInstallation")
    @ApiOperation("增加设施以及对应数量")
    public Result insertInstallation(@RequestBody List<ProjectInstallation> projectInstallations) {
        Result result = new Result(200, "插入成功");
        Integer flag = projectInstallationService.insertInstallation(projectInstallations);
        projectService.changeStage(projectInstallations.get(0).getProjectId());
        result.putData("flag", flag);
        return result;
    }

    @GetMapping("/queryInstallationList")
    @ApiOperation("查询设施价格")
    public Result queryInstallationList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", installationService.queryInstallationList(pageNum, pageSize));
        return result;
    }

    @GetMapping("/queryInstallationCountById")
    @ApiOperation("查询设施预算列表")
    public Result queryInstallationCountById(@RequestParam String id) {
        Result result = new Result(200, "查询成功");
        InstallationCountDto installationCountDto = installationService.queryInstallationCountById(id);
        result.putData("installationCountDto", installationCountDto);
        return result;
    }

    @PostMapping("/insertProjectCapital")
    @ApiOperation("插入工程预算金额")
    public Result insertProjectCapital(@RequestBody ProjectCapital projectCapital) {
        Result result = new Result(200, "插入成功");
        result.putData("flag", projectCapitalService.insertProjectCapital(projectCapital));
        return result;
    }

    @GetMapping("/queryProjectCapitalByProjectId")
    @ApiOperation("通过工程id查询查询工程信息和资金列表")
    public Result queryProjectCapitalByProjectId(@RequestParam String id) {
        Result result = new Result(200, "查询");
        //todo
        result.putData("projectCapitalDto", projectCapitalService.queryProjectCapitalByProjectId(id));
        return result;
    }

}
