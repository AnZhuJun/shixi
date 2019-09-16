package com.cs.tobaccosystem.bean;

import javax.persistence.*;

@Entity
@Table(name = "support")
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supportid;

    @Column
    private String name;

    public Support() {
    }

    public Support(int supportid, String name) {
        this.supportid = supportid;
        this.name = name;
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
}
