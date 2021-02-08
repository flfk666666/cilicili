package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_collectionvideo")
public class C_CollectionVideo {
    @Id
    private Integer cvid;
    private Integer uid;
    private Integer vid;
    private Date datetime;
    private String type;
    private String openYN;
    private String vname;
    private String Videocover;

    public Integer getCvid() {
        return cvid;
    }

    public void setCvid(Integer cvid) {
        this.cvid = cvid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenYN() {
        return openYN;
    }

    public void setOpenYN(String openYN) {
        this.openYN = openYN;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVideocover() {
        return Videocover;
    }

    public void setVideocover(String videocover) {
        Videocover = videocover;
    }

    @Override
    public String toString() {
        return "C_CollectionVideo{" +
                "cvid=" + cvid +
                ", uid=" + uid +
                ", vid=" + vid +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", openYN='" + openYN + '\'' +
                ", vname='" + vname + '\'' +
                ", Videocover='" + Videocover + '\'' +
                '}';
    }
}
