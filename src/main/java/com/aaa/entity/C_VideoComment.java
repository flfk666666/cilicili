package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "c_videocomment")
public class C_VideoComment {
    @Id
    private Integer vcid;
    private Integer vid;
    private String context;
    private Integer uid;
    private Date datetime;
    private Integer good;

    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
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

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "C_VideoComment{" +
                "vcid=" + vcid +
                ", vid=" + vid +
                ", context='" + context + '\'' +
                ", uid=" + uid +
                ", datetime=" + datetime +
                ", good=" + good +
                '}';
    }
}
