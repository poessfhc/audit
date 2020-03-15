package com.edu.audit.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: JsonResult
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/7 13:32
 * @Version: v1.0
 */
@Data
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    /**
     * 返回是否成功的状态, 1表示成功, 0表示失败
     */
    private int state;
    /**
     * 成功时候,返回的JSON数据
     */
    private Object data;
    /**
     * 是错误时候的错误消息
     */
    private String errmsg;
    /**
     * 是错误时候的错误码
     */
    private int errcode;

    private Serializable token;

    public JsonResult() {
        state = SUCCESS;
    }

    public JsonResult(int state, String msg, Serializable token) {
        this.state = state;
        this.errmsg = msg;
        this.token = token;
    }

    public JsonResult(int state, Object data, String errmsg, int errcode) {
        this.state = state;
        this.data = data;
        this.errmsg = errmsg;
        this.errcode = errcode;
    }

    public JsonResult(String errMsg, int errcode) {
        state = ERROR;
        data = null;
        this.errcode = errcode;
        this.errmsg = errMsg;
    }

    public JsonResult(Object data) {
        state = SUCCESS;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", data=" + data + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
    }
}
