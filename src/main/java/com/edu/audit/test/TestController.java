package com.edu.audit.test;

import com.edu.audit.authority.service.MenuService;
import com.edu.audit.business.dto.ProjectCapitalDto;
import com.edu.audit.business.service.InstallationService;
import com.edu.audit.business.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
    @Autowired
    InstallationService installationService;
    @Autowired
    MenuService menuService;

    @GetMapping("/fingTest")
    @ApiOperation("分页测试")
    public Object findTest(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        return projectService.findPage(pageNum, pageSize, stage);
    }

    @GetMapping("/changeStageTest")
    @ApiOperation("改变工程阶段")
    public Object changeStageTest(@RequestParam String id) {
        return projectService.changeStage(id);
    }

    @GetMapping("/queryProjectCapital")
    @ApiOperation("通过主键查询查询工程信息和资金列表")
    public ProjectCapitalDto queryProjectCapital(@RequestParam String id) {
        return projectService.queryProjectCapital(id);
    }

    @GetMapping("/queryInstallationList")
    @ApiOperation("查询设施价格")
    public Object queryInstallationList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return installationService.queryInstallationList(pageNum, pageSize);
    }

    @GetMapping("/updatePriceById")
    @ApiOperation("通过id更改设施价格")
    public Integer updatePriceById(@RequestParam BigDecimal price, @RequestParam Integer id) {
        return installationService.updatePriceById(price, id);
    }

    @GetMapping("/queryControlTypeList")
    @ApiOperation("查询菜单")
    public Object queryControlTypeList() {
        return menuService.queryControlTypeList();
    }
}
