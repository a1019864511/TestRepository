package com.example.demo.Entity;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/28
 */
public class Table {
    private int code;
    private String msg;
    private int count;
    private List<Order> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //返回给前端页面的表单数据
    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Table{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
