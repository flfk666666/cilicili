package com.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "c_recently")
public class C_Recently {
    @Id
    private Integer crid;
    private Integer id;
    private String videotitle;
    private String Videocover;
    private String introductio;
    private Date datetime;
    private String type;
    private Integer setNumber;
    private Integer uid;

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideotitle() {
        return videotitle;
    }

    public void setVideotitle(String videotitle) {
        this.videotitle = videotitle;
    }

    public String getVideocover() {
        return Videocover;
    }

    public void setVideocover(String videocover) {
        Videocover = videocover;
    }

    public String getIntroductio() {
        return introductio;
    }

    public void setIntroductio(String introductio) {
        this.introductio = introductio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "C_Recently{" +
                "crid=" + crid +
                ", id=" + id +
                ", videotitle='" + videotitle + '\'' +
                ", Videocover='" + Videocover + '\'' +
                ", introductio='" + introductio + '\'' +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", setNumber=" + setNumber +
                ", uid=" + uid +
                '}';
    }
}
