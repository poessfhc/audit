package com.edu.audit.business.controller;

import com.edu.audit.business.domain.ProjectInstallation;
import com.edu.audit.business.dto.InstallationCountDto;
import com.edu.audit.business.service.InstallationService;
import com.edu.audit.business.service.ProjectInstallationService;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ProjectController
 * @Description: TODO
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

}
