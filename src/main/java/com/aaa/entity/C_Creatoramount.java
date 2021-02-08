package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_creatoramount")
public class C_Creatoramount {
    private String money;
    private Integer uid;
    private Date vtime;
    private String tmode;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
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

    public String getTmode() {
        return tmode;
    }

    public void setTmode(String tmode) {
        this.tmode = tmode;
    }

    @Override
    public String toString() {
        return "C_Creatoramount{" +
                "money='" + money + '\'' +
                ", uid=" + uid +
                ", vtime=" + vtime +
                ", tmode='" + tmode + '\'' +
                '}';
    }
}
