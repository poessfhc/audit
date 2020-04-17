package com.edu.audit.sysLog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: SysLog
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/17 21:34
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
public class SysLog {
    private Integer id;
    private String username;
    private String operation;
    @JsonFormat(timezone = "GMT-5", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String method;
    private String params;
    private String ip;
    @JsonFormat(timezone = "GMT-5", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public SysLog(String username, String operation, String method, String ip) {
        this.username = username;
        this.operation = operation;
        this.method = method;
        this.ip = ip;
    }
}
