package com.edu.audit.business.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: QueryTask
 * @Description: 定时任务
 * @Author: Vince
 * @Date: 2020/4/4 15:31
 * @Version: v1.0
 */
@Component
public class QueryTask {
    /**
     * 每天21点定时往进度表插入数据
     * */
    @Scheduled(cron = "0 0 21 * * ?")
    public void insertTask(){
        //todo 查询数据
        //todo 进度表中插入数据
    }
}
