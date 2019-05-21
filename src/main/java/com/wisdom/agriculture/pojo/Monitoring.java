package com.wisdom.agriculture.pojo;

public class Monitoring {
    private Integer id;

    private String aid;

    private String ip;

    public Monitoring(Integer id, String aid, String ip) {
        this.id = id;
        this.aid = aid;
        this.ip = ip;
    }

    public Monitoring() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}