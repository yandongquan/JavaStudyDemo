package com.javazhan.core.model.pojo;

import java.io.Serializable;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 9:40 2018/3/27
 * @Modified By:
 */
public class ResponseData implements Serializable {

    private String code;
    private String msg;
    private String data;

    public ResponseData() {}

    public ResponseData(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
