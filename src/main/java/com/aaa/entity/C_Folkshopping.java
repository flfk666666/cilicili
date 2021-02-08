package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_folkshopping")
public class C_Folkshopping {
    @Id
    private Integer fsid;//编号
    private String folkname;//番剧名称
    private String context;//理由
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datetime;//日期
    private Integer uid;//用户外键

    public Integer getFsid() {
        return fsid;
    }

    public void setFsid(Integer fsid) {
        this.fsid = fsid;
    }

    public String getFolkname() {
        return folkname;
    }

    public void setFolkname(String folkname) {
        this.folkname = folkname;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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
        return "C_Folkshopping{" +
                "fsid=" + fsid +
                ", folkname='" + folkname + '\'' +
                ", context='" + context + '\'' +
                ", datetime=" + datetime +
                ", uid=" + uid +
                '}';
    }
}
