package com.cs.tobaccosystem.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tobacco")
public class Tobacco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tobaccoid;

    @Column
    private String name;

    @Column
    private int supportid;

    @Column
    private int price;

    public Tobacco() {
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "tobaccoid=" + tobaccoid +
                ", name='" + name + '\'' +
                ", supportid=" + supportid +
                ", price=" + price +
                '}';
    }

    public int getTobaccoid() {
        return tobaccoid;
    }

    public void setTobaccoid(int tobaccoid) {
        this.tobaccoid = tobaccoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupportid() {
        return supportid;
    }

    public void setSupportid(int supportid) {
        this.supportid = supportid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Tobacco(int tobaccoid, String name, int supportid, int price) {
        this.tobaccoid = tobaccoid;
        this.name = name;
        this.supportid = supportid;
        this.price = price;
    }
}
