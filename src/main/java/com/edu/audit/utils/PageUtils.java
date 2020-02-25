package com.edu.audit.utils;

import com.github.pagehelper.PageInfo;

/**
 * @ClassName: PageUtils
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/25 15:33
 * @Version: v1.0
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     */
    public static PageResult getPageResult(Integer pageNum, Integer pageSize, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
