package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_recordaward")
public class C_Recordaward {
    private Integer vid;
    private String prices;
    private Date datetime;
    private Integer uid;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "C_Recordaward{" +
                "vid=" + vid +
                ", prices='" + prices + '\'' +
                ", datetime=" + datetime +
                ", uid=" + uid +
                '}';
    }
}
