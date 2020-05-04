package com.example.demo.common;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:05 2020/5/4
 */
public class CommonReturnType {
    private int status;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
