package com.cs.tobaccosystem.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "support")
public class Support implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supportid;

    @Column
    private String name;

    @Column
    private String telephone;

    @Column
    private String information;

    public Support() {
    }

    public Support(int supportid, String name,String telephone,String information) {
        this.supportid = supportid;
        this.name = name;
        this.telephone = telephone;
        this.information = information;
    }

    @Override
    public String toString() {
        return "Support{" +
                "supportid=" + supportid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSupportid() {
        return supportid;
    }

    public void setSupportid(int supportid) {
        this.supportid = supportid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
