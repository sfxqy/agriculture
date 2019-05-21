package com.wisdom.agriculture.pojo;

public class Dtype {
    private Integer tid;

    private String type;

    public Dtype(Integer tid, String type) {
        this.tid = tid;
        this.type = type;
    }

    public Dtype() {
        super();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}