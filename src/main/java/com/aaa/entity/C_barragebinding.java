package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class C_barragebinding {

    @Id
    private Integer id;
    private Integer vid;

    @Override
    public String toString() {
        return "C_barragebinding{" +
                "id=" + id +
                ", vid=" + vid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public C_barragebinding() {
    }

    public C_barragebinding(Integer id, Integer vid) {
        this.id = id;
        this.vid = vid;
    }
}
