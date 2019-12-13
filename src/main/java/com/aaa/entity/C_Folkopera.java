package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_folkopera")
public class C_Folkopera {
    @Id
    private Integer fid;
    private Integer uid;
    private String fname;
    private String folkcover;
    private String folkintroduction;
    private String state;
    private String company;
    private String Severalepisodes;
    private Integer Fabulous;
    private String stateupdate;
    private String workup;
    private Integer PlaybackValue;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSeveralepisodes() {
        return Severalepisodes;
    }

    public void setSeveralepisodes(String severalepisodes) {
        Severalepisodes = severalepisodes;
    }

    public Integer getFabulous() {
        return Fabulous;
    }

    public void setFabulous(Integer fabulous) {
        Fabulous = fabulous;
    }

    public String getStateupdate() {
        return stateupdate;
    }

    public void setStateupdate(String stateupdate) {
        this.stateupdate = stateupdate;
    }

    public String getWorkup() {
        return workup;
    }

    public void setWorkup(String workup) {
        this.workup = workup;
    }

    public Integer getPlaybackValue() {
        return PlaybackValue;
    }

    public void setPlaybackValue(Integer playbackValue) {
        PlaybackValue = playbackValue;
    }

    @Override
    public String toString() {
        return "C_Folkopera{" +
                "fid=" + fid +
                ", uid=" + uid +
                ", fname='" + fname + '\'' +
                ", folkcover='" + folkcover + '\'' +
                ", folkintroduction='" + folkintroduction + '\'' +
                ", state='" + state + '\'' +
                ", company='" + company + '\'' +
                ", Severalepisodes='" + Severalepisodes + '\'' +
                ", Fabulous=" + Fabulous +
                ", stateupdate='" + stateupdate + '\'' +
                ", workup='" + workup + '\'' +
                ", PlaybackValue=" + PlaybackValue +
                '}';
    }
}
