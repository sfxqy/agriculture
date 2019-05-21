package com.wisdom.agriculture.pojo;

public class Abnormal {
    private Integer id;

    private Integer did;

    private Integer daid;

    public Abnormal(Integer id, Integer did, Integer daid) {
        this.id = id;
        this.did = did;
        this.daid = daid;
    }

    public Abnormal() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }
}