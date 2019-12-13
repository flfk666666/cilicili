package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_barragehistory")
public class C_BarrageHistory {
    private Integer id;
    private String text;
    private Integer uid;
    private Date vtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }

    @Override
    public String toString() {
        return "C_BarrageHistory{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", uid=" + uid +
                ", vtime=" + vtime +
                '}';
    }
}
