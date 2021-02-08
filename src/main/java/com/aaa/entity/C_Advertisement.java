package com.aaa.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_advertisement")
public class C_Advertisement {
    @Id
    private int aid;
    private String atitle;
    private String aurl;
    private String aimg;
    private String type;


    public C_Advertisement() {
    }



    public C_Advertisement(int aid, String atitle, String aurl, String aimg, String type) {
        this.aid = aid;
        this.atitle = atitle;
        this.aurl = aurl;
        this.aimg = aimg;
        this.type = type;
    }

    @Override
    public String toString() {
        return "C_Advertisement{" +
                "aid=" + aid +
                ", atitle='" + atitle + '\'' +
                ", aurl='" + aurl + '\'' +
                ", aimg='" + aimg + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }
}
