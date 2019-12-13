package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_folknumber")
public class C_Folknumber {
    private Integer fid;
    private String fnumber;
    private String ftitle;
    private String fcontext;
    private String state;
    private Date updatetime;

    public C_Folknumber(Integer fid, String fnumber, String ftitle, String fcontext, String state, Date updatetime) {
        this.fid = fid;
        this.fnumber = fnumber;
        this.ftitle = ftitle;
        this.fcontext = fcontext;
        this.state = state;
        this.updatetime = updatetime;
    }

    public C_Folknumber() {
    }

    @Override
    public String toString() {
        return "C_Folknumber{" +
                "fid=" + fid +
                ", fnumber='" + fnumber + '\'' +
                ", ftitle='" + ftitle + '\'' +
                ", fcontext='" + fcontext + '\'' +
                ", state='" + state + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
