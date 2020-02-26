package com.edu.audit.test;

import com.edu.audit.business.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/25 15:40
 * @Version: v1.0
 */
@RestController
@RequestMapping("/test")
@Api(value = "接口测试")
public class TestController {
    @Autowired
    ProjectService projectService;

    @GetMapping("fingTest")
    @ApiOperation("分页测试")
    public Object findTest(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        return projectService.findPage(pageNum, pageSize, stage);
    }

    @GetMapping("changeStageTest")
    @ApiOperation("改变工程阶段")
    public Object changeStageTest(@RequestParam String id) {
        return projectService.changeStage(id);
    }
}
