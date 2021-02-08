package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_folkreply")
public class C_FolkReply {
    @Id
    private Integer frid;
    private Integer fcid;
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

    public Integer getFrid() {
        return frid;
    }

    public void setFrid(Integer frid) {
        this.frid = frid;
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
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
        return "C_FolkReply{" +
                "frid=" + frid +
                ", fcid=" + fcid +
                ", context='" + context + '\'' +
                ", uid=" + uid +
                ", datetime=" + datetime +
                ", good=" + good +
                '}';
    }
}
