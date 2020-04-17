package com.edu.audit.sysLog.controller;

import com.edu.audit.sysLog.service.SysLogService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysLogController
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 23:32
 * @Version: v1.0
 */
@RestController
@RequestMapping("/log")
@Api(value = "日志管理")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;

    @ApiOperation("查询日志")
    @GetMapping("/querySysLog")
    public Result querySysLog(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = new Result(200, "查询成功");
        result.putData("pageResult", sysLogService.querySysLog(pageNum, pageSize));
        return result;
    }
}
