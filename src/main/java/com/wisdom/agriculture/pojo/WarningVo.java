package com.wisdom.agriculture.pojo;

import java.util.Date;

/**
 * @author SFX
 * 预警信息实体类
 */
public class WarningVo {


    private Integer daid;

    private Integer did;

    private Float value;

    private Date time;


    private Integer deviceid;

    private String devicename;

    private Float longitude;

    private Float latitude;

    private String place;


    private Float warnmax;

    private Float warnmin;


    public WarningVo() {
    }

    public WarningVo(Integer daid, Integer did, Float value, Date time, Integer deviceid, String devicename, Float longitude, Float latitude, String place, Float warnmax, Float warnmin) {
        this.daid = daid;
        this.did = did;
        this.value = value;
        this.time = time;
        this.deviceid = deviceid;
        this.devicename = devicename;
        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
        this.warnmax = warnmax;
        this.warnmin = warnmin;
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

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
