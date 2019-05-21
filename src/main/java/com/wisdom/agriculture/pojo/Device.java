package com.wisdom.agriculture.pojo;

public class Device {
    private Integer deid;

    private Integer deviceid;

    private String devicename;

    private String appkey;

    private Integer online;

    private Float longitude;

    private Float latitude;

    private String place;



    public Device( String devicename, String appkey, Integer online, Float longitude, Float latitude, String place) {
        this.devicename = devicename;
        this.appkey = appkey;
        this.online = online;
        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
    }

    public Device(Integer deid, Integer deviceid, String devicename, String appkey, Integer online, Float longitude, Float latitude, String place) {
        this.deid = deid;
        this.deviceid = deviceid;
        this.devicename = devicename;
        this.appkey = appkey;
        this.online = online;
        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
    }

    public Device() {
        super();
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
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
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
        this.place = place == null ? null : place.trim();
    }
}