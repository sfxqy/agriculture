package com.wisdom.agriculture.pojo;


/**
 * 采集器VO类
 */
public class DetailsVo {


    private Integer deid;

    private Integer deviceid;

    private String devicename;

    private String appkey;

    private Integer online;

    private Float longitude;

    private Float latitude;

    private String place;

    private Integer did;

    private String type;

    private Integer tid;

    private Float max;

    private Float min;

    private Float warnmax;

    private Float warnmin;

    public DetailsVo() {
    }

    public DetailsVo(Integer deid, Integer deviceid, String devicename, String appkey, Integer online, Float longitude, Float latitude, String place, Integer did, String type, Integer tid, Float max, Float min, Float warnmax, Float warnmin) {
        this.deid = deid;
        this.deviceid = deviceid;
        this.devicename = devicename;
        this.appkey = appkey;
        this.online = online;
        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
        this.did = did;
        this.type = type;
        this.tid = tid;
        this.max = max;
        this.min = min;
        this.warnmax = warnmax;
        this.warnmin = warnmin;
    }

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
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

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
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

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
