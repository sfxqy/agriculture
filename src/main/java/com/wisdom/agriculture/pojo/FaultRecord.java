package com.wisdom.agriculture.pojo;

import io.swagger.models.auth.In;

/**
 * @author SFX
 * 故障记录实体类
 */
public class FaultRecord {

    private Integer id;

    private Integer deviceId;

    private Integer deviceName;

    private double longitude;

    private double latitude;

    private String place;

    private Integer did;

    private String type;

    private float value;

    private String time;


    public FaultRecord() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FaultRecord(Integer id, Integer deviceId, Integer deviceName, double longitude, double latitude, String place, Integer did, String type, float value, String time) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.place = place;
        this.did = did;
        this.type = type;
        this.value = value;
        this.time = time;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(Integer deviceName) {
        this.deviceName = deviceName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
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
}
