package com.aaa.entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_useradmin")
public class C_UserAdmin {

    @Id
    private Integer uid;
    private String uname;
    private String pwd;
    private String alias;
    private String identity;
    private Integer Grade;
    private Integer Empirical;
    private Integer CCoin;
    private String state;
    private String Paymentpwd;
    private String Personalized;
    private String Spacedeclaration;
    private String QQ;
    private String Headimg;
    private String sex;
    private String spaceimg;

    public C_UserAdmin() {
    }

    public C_UserAdmin(Integer uid, String uname, String pwd, String alias, String identity, Integer grade, Integer empirical, Integer CCoin, String state, String paymentpwd, String personalized, String spacedeclaration, String QQ, String headimg, String sex, String spaceimg) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.alias = alias;
        this.identity = identity;
        Grade = grade;
        Empirical = empirical;
        this.CCoin = CCoin;
        this.state = state;
        Paymentpwd = paymentpwd;
        Personalized = personalized;
        Spacedeclaration = spacedeclaration;
        this.QQ = QQ;
        Headimg = headimg;
        this.sex = sex;
        this.spaceimg = spaceimg;
    }

    @Override
    public String toString() {
        return "C_UserAdmin{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", alias='" + alias + '\'' +
                ", identity='" + identity + '\'' +
                ", Grade=" + Grade +
                ", Empirical=" + Empirical +
                ", CCoin=" + CCoin +
                ", state='" + state + '\'' +
                ", Paymentpwd='" + Paymentpwd + '\'' +
                ", Personalized='" + Personalized + '\'' +
                ", Spacedeclaration='" + Spacedeclaration + '\'' +
                ", QQ='" + QQ + '\'' +
                ", Headimg='" + Headimg + '\'' +
                ", sex='" + sex + '\'' +
                ", spaceimg='" + spaceimg + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
    }

    public Integer getEmpirical() {
        return Empirical;
    }

    public void setEmpirical(Integer empirical) {
        Empirical = empirical;
    }

    public Integer getCCoin() {
        return CCoin;
    }

    public void setCCoin(Integer CCoin) {
        this.CCoin = CCoin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPaymentpwd() {
        return Paymentpwd;
    }

    public void setPaymentpwd(String paymentpwd) {
        Paymentpwd = paymentpwd;
    }

    public String getPersonalized() {
        return Personalized;
    }

    public void setPersonalized(String personalized) {
        Personalized = personalized;
    }

    public String getSpacedeclaration() {
        return Spacedeclaration;
    }

    public void setSpacedeclaration(String spacedeclaration) {
        Spacedeclaration = spacedeclaration;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getHeadimg() {
        return Headimg;
    }

    public void setHeadimg(String headimg) {
        Headimg = headimg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpaceimg() {
        return spaceimg;
    }

    public void setSpaceimg(String spaceimg) {
        this.spaceimg = spaceimg;
    }
}
