package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_subscribe")
public class C_Subscribe {
    @Id
    private Integer sbid;
    private Integer fid;
    private Integer uid;
    private String openYN;
    private String folkcover;
    private String folkintroduction;
    private String folkname;
    private Date datetime;

    public C_Subscribe(Integer sbid, Integer fid, Integer uid, String openYN, String folkcover, String folkintroduction, String folkname, Date datetime) {
        this.sbid = sbid;
        this.fid = fid;
        this.uid = uid;
        this.openYN = openYN;
        this.folkcover = folkcover;
        this.folkintroduction = folkintroduction;
        this.folkname = folkname;
        this.datetime = datetime;
    }

    public C_Subscribe() {
    }

    @Override
    public String toString() {
        return "C_Subscribe{" +
                "sbid=" + sbid +
                ", fid=" + fid +
                ", uid=" + uid +
                ", openYN='" + openYN + '\'' +
                ", folkcover='" + folkcover + '\'' +
                ", folkintroduction='" + folkintroduction + '\'' +
                ", folkname='" + folkname + '\'' +
                ", datetime=" + datetime +
                '}';
    }


    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenYN() {
        return openYN;
    }

    public void setOpenYN(String openYN) {
        this.openYN = openYN;
    }

    public String getFolkcover() {
        return folkcover;
    }

    public void setFolkcover(String folkcover) {
        this.folkcover = folkcover;
    }

    public String getFolkintroduction() {
        return folkintroduction;
    }

    public void setFolkintroduction(String folkintroduction) {
        this.folkintroduction = folkintroduction;
    }

    public String getFolkname() {
        return folkname;
    }

    public void setFolkname(String folkname) {
        this.folkname = folkname;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
