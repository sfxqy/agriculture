package com.wisdom.agriculture.pojo;

public class Customer {
    private Integer cid;

    private String username;

    private String password;

    private String name;

    private String phone;

    private Integer rid;

    private String type;

    public Customer( String username, String password, String name, String phone, Integer rid) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.rid = rid;
    }


    public Customer(Integer cid, String username, String password, String name, String phone, Integer rid) {
        this.cid = cid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.rid = rid;
    }


    public Customer(Integer cid, String username, String password, String name, String phone, Integer rid, String type) {
        this.cid = cid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.rid = rid;
        this.type = type;
    }

    public Customer() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}