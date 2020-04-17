package com.edu.audit.sysLog.service;

import com.edu.audit.utils.PageResult;

/**
 * @ClassName: SysLogService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 23:27
 * @Version: v1.0
 */
public interface SysLogService {
    public PageResult querySysLog(Integer pageNum,Integer pageSize);
}
