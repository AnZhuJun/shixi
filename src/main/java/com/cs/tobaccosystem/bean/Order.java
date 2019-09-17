package com.cs.tobaccosystem.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @Column
    private int tobaccoid;

    @Column
    private Date createdate;

    public Order() {
    }

    public Order(int orderid, int tobaccoid, Date createdate) {
        this.orderid = orderid;
        this.tobaccoid = tobaccoid;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", tobaccoid=" + tobaccoid +
                ", createdate=" + createdate +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getTobaccoid() {
        return tobaccoid;
    }

    public void setTobaccoid(int tobaccoid) {
        this.tobaccoid = tobaccoid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
