package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
public class C_tjVideo {
    @Id
    private Integer vid;
    private Integer uid;
    private Integer vfid;
    private String vname;
    private String Videocover;
    private String context;
    private String Videointroduction;
    private String state;
    private String Z_index;
    private Integer Fabulous;
    private Integer PlaybackValue;
    private Date vtime;
    private String uname;
    private int dmcount;

    public C_tjVideo(Integer vid, Integer uid, Integer vfid, String vname, String videocover, String context, String videointroduction, String state, String z_index, Integer fabulous, Integer playbackValue, Date vtime, String uname, int dmcount) {
        this.vid = vid;
        this.uid = uid;
        this.vfid = vfid;
        this.vname = vname;
        Videocover = videocover;
        this.context = context;
        Videointroduction = videointroduction;
        this.state = state;
        Z_index = z_index;
        Fabulous = fabulous;
        PlaybackValue = playbackValue;
        this.vtime = vtime;
        this.uname = uname;
        this.dmcount = dmcount;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getDmcount() {
        return dmcount;
    }

    public void setDmcount(int dmcount) {
        this.dmcount = dmcount;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVfid() {
        return vfid;
    }

    public void setVfid(Integer vfid) {
        this.vfid = vfid;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getVideointroduction() {
        return Videointroduction;
    }

    public void setVideointroduction(String videointroduction) {
        Videointroduction = videointroduction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZ_index() {
        return Z_index;
    }

    public void setZ_index(String z_index) {
        Z_index = z_index;
    }

    public Integer getFabulous() {
        return Fabulous;
    }

    public void setFabulous(Integer fabulous) {
        Fabulous = fabulous;
    }

    public Integer getPlaybackValue() {
        return PlaybackValue;
    }

    public void setPlaybackValue(Integer playbackValue) {
        PlaybackValue = playbackValue;
    }

    public C_tjVideo() {
    }


    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }
}
