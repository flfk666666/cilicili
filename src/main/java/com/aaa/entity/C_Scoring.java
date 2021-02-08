package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "C_Scoring")
public class C_Scoring {
    @Id
    private int sid;
    private int uid;
    private int fraction;
    private int fid;
    private String uname;
    private Date vtime;
    private String scoringcontext;


    public C_Scoring(int sid, int uid, int fraction, int fid, String uname, Date vtime, String scoringcontext) {
        this.sid = sid;
        this.uid = uid;
        this.fraction = fraction;
        this.fid = fid;
        this.uname = uname;
        this.vtime = vtime;
        this.scoringcontext = scoringcontext;
    }

    public C_Scoring() {
    }

    @Override
    public String toString() {
        return "C_Scoring{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", fraction=" + fraction +
                ", fid=" + fid +
                ", uname='" + uname + '\'' +
                ", vtime=" + vtime +
                ", scoringcontext='" + scoringcontext + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }

    public String getScoringcontext() {
        return scoringcontext;
    }

    public void setScoringcontext(String scoringcontext) {
        this.scoringcontext = scoringcontext;
    }
}
