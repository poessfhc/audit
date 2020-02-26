package com.edu.audit.utils;

/**
 * @ClassName: Identification
 * @Description: 数据标识类
 * @Author: Vince
 * @Date: 2020/2/25 13:51
 * @Version: v1.0
 */
public class Identification {
    /**
     * 角色标识
     */
    public static class Role {
        /**
         * 管理员
         */
        public static final Integer ADMIN = 1;
        /**
         * 实施负责人
         */
        public static final Integer SHISHIFUZEREN = 1;
        /**
         * 审核管理员
         */
        public static final Integer SHENHEGUANLIYUAN = 1;
        /**
         * 资金管理员
         */
        public static final Integer ZIJINGUANLIYUAN = 1;
        /**
         * 督察管理员
         */
        public static final Integer DUCHAGUANLIYUAN = 1;
        /**
         * 局领导
         */
        public static final Integer JULINGDAO = 1;
    }

    /**
     * 工程审核阶段标识
     */
    public static class Project {
        /**
         * 立项
         */
        public static final Integer LIXIANG = 1;
        /**
         * 立项审批中
         */
        public static final Integer LIXIANGZHONG = 2;
        /**
         * 预算
         */
        public static final Integer YUSUAN = 3;
        /**
         * 预算审批中
         */
        public static final Integer YUSUANZHONG = 4;
        /**
         * 拨付
         */
        public static final Integer BOFU = 5;
        /**
         * 拨付审批中
         */
        public static final Integer BOFUZHONG = 6;
        /**
         * 结算
         */
        public static final Integer JIESUAN = 7;
        /**
         * 结算审批中
         */
        public static final Integer JIESUANZHONG = 8;
        /**
         * 实施中
         */
        public static final Integer SHISHI = 9;
        /**
         * 实施结束
         */
        public static final Integer SHISHIJIESHU = 10;

    }
}
