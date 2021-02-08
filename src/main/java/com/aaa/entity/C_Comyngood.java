package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_comyngood")
public class C_Comyngood {
    private Integer uid;
    private Integer vcid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVcid() {
        return vcid;
    }

    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    @Override
    public String toString() {
        return "C_Comyngood{" +
                "uid=" + uid +
                ", vcid=" + vcid +
                '}';
    }
}
