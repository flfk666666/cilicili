package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_news")
public class C_News {
    @Id
    private Integer nid;
    private String ncontext;
    private Date datetime;
    private String type;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNcontext() {
        return ncontext;
    }

    public void setNcontext(String ncontext) {
        this.ncontext = ncontext;
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

    @Override
    public String toString() {
        return "C_News{" +
                "nid=" + nid +
                ", ncontext='" + ncontext + '\'' +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                '}';
    }
}
