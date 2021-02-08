package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_folkbinding")
public class C_Folkbinding {
    private Integer id;
    private Integer fid;
    private Integer fnumber;

    public C_Folkbinding(Integer id, Integer fid, Integer fnumber) {
        this.id = id;
        this.fid = fid;
        this.fnumber = fnumber;
    }

    public C_Folkbinding() {
    }

    @Override
    public String toString() {
        return "C_Folkbinding{" +
                "id=" + id +
                ", fid=" + fid +
                ", fnumber=" + fnumber +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFnumber() {
        return fnumber;
    }

    public void setFnumber(Integer fnumber) {
        this.fnumber = fnumber;
    }
}
