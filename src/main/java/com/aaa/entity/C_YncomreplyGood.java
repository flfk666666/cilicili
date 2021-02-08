package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_yncomreplygood")
public class C_YncomreplyGood {
    private Integer uid;
    private Integer vrid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVrid() {
        return vrid;
    }

    public void setVrid(Integer vrid) {
        this.vrid = vrid;
    }

    @Override
    public String toString() {
        return "C_YncomreplyGood{" +
                "uid=" + uid +
                ", vrid=" + vrid +
                '}';
    }
}
