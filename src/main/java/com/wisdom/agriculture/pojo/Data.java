package com.wisdom.agriculture.pojo;

import java.util.Date;

public class Data {
    private Integer daid;

    private Integer did;

    private Float value;

    private Date time;

    public Data(Integer daid, Integer did, Float value, Date time) {
        this.daid = daid;
        this.did = did;
        this.value = value;
        this.time = time;
    }

    public Data() {
        super();
    }

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}