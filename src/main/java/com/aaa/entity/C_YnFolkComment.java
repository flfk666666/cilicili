package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_ynfolkcomment")
public class C_YnFolkComment {
    private Integer uid;
    private Integer fcid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    @Override
    public String toString() {
        return "C_YnFolkComment{" +
                "uid=" + uid +
                ", fcid=" + fcid +
                '}';
    }
}
