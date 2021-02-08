package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_follow")
public class C_Follow {

    private Integer uid;
    private Integer fuid;

    public C_Follow(Integer uid, Integer fuid) {
        this.uid = uid;
        this.fuid = fuid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public C_Follow() {
    }

    @Override
    public String toString() {
        return "C_Follow{" +
                "uid=" + uid +
                ", fuid=" + fuid +
                '}';
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }
}
