package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_folkcomment")
public class C_FolkComment {
    @Id
    private Integer fcid;
    private Integer fid;
    private String context;
    private Date datetime;
    private Integer uid;
    private Integer good;

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "C_FolkComment{" +
                "fcid=" + fcid +
                ", fid=" + fid +
                ", context='" + context + '\'' +
                ", datetime=" + datetime +
                ", uid=" + uid +
                ", good=" + good +
                '}';
    }
}
