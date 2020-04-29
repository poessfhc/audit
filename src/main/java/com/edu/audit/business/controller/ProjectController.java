package com.edu.audit.business.controller;

import com.edu.audit.business.domain.ProjectInstallation;
import com.edu.audit.business.service.ProjectInstallationService;
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

    @PostMapping("/insertInstallation")
    @ApiOperation("增加设施以及对应数量")
    public Result insertInstallation(@RequestBody List<ProjectInstallation> projectInstallations) {
        Result result = new Result(200, "插入成功");
        Integer flag = projectInstallationService.insertInstallation(projectInstallations);
        result.putData("flag", flag);
        return result;
    }

}
