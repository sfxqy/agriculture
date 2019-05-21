package com.wisdom.agriculture.pojo;

public class Role {
    private Integer id;

    private Integer rid;

    private String rname;

    public Role(Integer id, Integer rid, String rname) {
        this.id = id;
        this.rid = rid;
        this.rname = rname;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }
}