package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class C_list {
    @Id
    private Integer lid;
    private String lname;
    private String href;
    private String ljoin;


    public C_list() {
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLjoin() {
        return ljoin;
    }

    public void setLjoin(String ljoin) {
        this.ljoin = ljoin;
    }

    public C_list(Integer lid, String lname, String href, String ljoin) {
        this.lid = lid;
        this.lname = lname;
        this.href = href;
        this.ljoin = ljoin;
    }

    @Override
    public String toString() {
        return "C_list{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", href='" + href + '\'' +
                ", ljoin='" + ljoin + '\'' +
                '}';
    }
}
