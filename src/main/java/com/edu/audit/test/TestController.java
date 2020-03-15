package com.edu.audit.test;

import com.edu.audit.authority.service.MenuService;
import com.edu.audit.business.dto.ProjectCapitalDto;
import com.edu.audit.business.service.InstallationService;
import com.edu.audit.business.service.ProjectService;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.Result;
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
    public Result findTest(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer stage) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", projectService.findPage(pageNum, pageSize, stage));
        return result;
    }

    @GetMapping("/changeStageTest")
    @ApiOperation("改变工程阶段")
    public Result changeStageTest(@RequestParam String id) {
        Result result = new Result(200, "变更成功");
        result.putData("flag", projectService.changeStage(id));
        return result;
    }

    @GetMapping("/queryProjectCapital")
    @ApiOperation("通过主键查询查询工程信息和资金列表")
    public Result queryProjectCapital(@RequestParam String id) {
        Result result = new Result(200, "查询成功");
        result.putData("projectCapital",projectService.queryProjectCapital(id));
        return result;
    }

    @GetMapping("/queryInstallationList")
    @ApiOperation("查询设施价格")
    public Result queryInstallationList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult",installationService.queryInstallationList(pageNum, pageSize));
        return result;
    }

    @GetMapping("/updatePriceById")
    @ApiOperation("通过id更改设施价格")
    public Result updatePriceById(@RequestParam BigDecimal price, @RequestParam Integer id) {
        Result result = new Result(200, "变更成功");
        result.putData("flag",installationService.updatePriceById(price, id));
        return result;
    }

    @GetMapping("/queryControlTypeList")
    @ApiOperation("查询菜单")
    public Result queryControlTypeList() {
        Result result = new Result(200, "查询成功");
        result.putData("menu",menuService.queryControlTypeList());
        return result;
    }
}
