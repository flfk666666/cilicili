package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_videoclassification")
public class C_VideoClassification {
    @Id
    private Integer vfid;
    private String vcname;
    private String state;

    public Integer getVfid() {
        return vfid;
    }

    public void setVfid(Integer vfid) {
        this.vfid = vfid;
    }

    public String getVcname() {
        return vcname;
    }

    public void setVcname(String vcname) {
        this.vcname = vcname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "C_VideoClassification{" +
                "vfid=" + vfid +
                ", vcname='" + vcname + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
