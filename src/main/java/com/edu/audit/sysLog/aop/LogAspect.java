package com.edu.audit.sysLog.aop;

import com.edu.audit.sysLog.dao.SysLogDao;
import com.edu.audit.sysLog.domain.SysLog;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName: LogAspect
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 21:39
 * @Version: v1.0
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("execution(public * com.edu.audit.authority.controller..*.*(..)) || execution(public * com.edu.audit.business.controller..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        if (SecurityUtils.getSubject().getPrincipal() == null) {
            SysLog sysLog = new SysLog("", request.getMethod(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), request.getRemoteAddr());
            sysLogDao.insertSysLog(sysLog);
        } else {
            String username = SecurityUtils.getSubject().getPrincipal().toString();
            SysLog sysLog = new SysLog(username, request.getMethod(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), request.getRemoteAddr());
            sysLogDao.insertSysLog(sysLog);
        }
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
