package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_ynfolkreply")
public class C_YnFolkReply {
    private Integer uid;
    private Integer frid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFrid() {
        return frid;
    }

    public void setFrid(Integer frid) {
        this.frid = frid;
    }

    @Override
    public String toString() {
        return "C_YnFolkReply{" +
                "uid=" + uid +
                ", frid=" + frid +
                '}';
    }
}
