package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_videoreply")
public class C_VideoReply {
    @Id
    private Integer vrid;
    private Integer vcid;
    private String context;
    private Integer uid;
    private Date datetime;
    private Integer good;

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getVrid() {
        return vrid;
    }

    public void setVrid(Integer vrid) {
        this.vrid = vrid;
    }

    public Integer getVcid() {
        return vcid;
    }

    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "C_VideoReply{" +
                "vrid=" + vrid +
                ", vcid=" + vcid +
                ", context='" + context + '\'' +
                ", uid=" + uid +
                ", datetime=" + datetime +
                ", good=" + good +
                '}';
    }
}
