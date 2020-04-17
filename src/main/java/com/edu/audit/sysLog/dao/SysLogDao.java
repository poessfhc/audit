package com.edu.audit.sysLog.dao;

import com.edu.audit.sysLog.domain.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: SysLogDao
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 21:45
 * @Version: v1.0
 */
@Mapper
public interface SysLogDao {
    List<SysLog> querySysLogList();

    int insertSysLog(SysLog sysLog);
}
