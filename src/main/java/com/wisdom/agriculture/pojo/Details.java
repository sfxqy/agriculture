package com.wisdom.agriculture.pojo;

public class Details {
    private Integer did;

    private Integer deviceid;

    private Integer tid;

    private Float max;

    private Float min;

    private Float warnmax;

    private Float warnmin;

    public Details(Integer did, Integer deviceid, Integer tid, Float max, Float min, Float warnmax, Float warnmin) {
        this.did = did;
        this.deviceid = deviceid;
        this.tid = tid;
        this.max = max;
        this.min = min;
        this.warnmax = warnmax;
        this.warnmin = warnmin;
    }

    public Details() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getWarnmax() {
        return warnmax;
    }

    public void setWarnmax(Float warnmax) {
        this.warnmax = warnmax;
    }

    public Float getWarnmin() {
        return warnmin;
    }

    public void setWarnmin(Float warnmin) {
        this.warnmin = warnmin;
    }
}