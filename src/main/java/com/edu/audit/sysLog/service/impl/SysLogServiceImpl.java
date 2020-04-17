package com.edu.audit.sysLog.service.impl;

import com.edu.audit.sysLog.dao.SysLogDao;
import com.edu.audit.sysLog.domain.SysLog;
import com.edu.audit.sysLog.service.SysLogService;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: SysLogServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 23:27
 * @Version: v1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao sysLogDao;

    @Override
    public PageResult querySysLog(Integer pageNum, Integer pageSize) {
        return PageUtils.getPageResult(pageNum, pageSize, getPageInfo(pageNum, pageSize));
    }

    private PageInfo<SysLog> getPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> projects = sysLogDao.querySysLogList();
        return new PageInfo<SysLog>(projects);
    }

}
