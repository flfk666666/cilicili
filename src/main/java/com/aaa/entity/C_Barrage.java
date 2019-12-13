package com.aaa.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "C_Barrage")
public class C_Barrage {

    @Id
    private Integer id;
    private String text;
    private String color;
    private String size;
    private String position;
    private String time;

    public C_Barrage() {
    }

    public C_Barrage(Integer id, String text, String color, String size, String position, String time) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.size = size;
        this.position = position;
        this.time = time;
    }

    @Override
    public String toString() {
        return "test_dm{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", position='" + position + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
