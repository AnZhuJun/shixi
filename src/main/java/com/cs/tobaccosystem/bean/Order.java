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

    @Column
    private int userid;

    public Order() {
    }

    public Order(int orderid, int tobaccoid, int userid,Date createdate) {
        this.orderid = orderid;
        this.tobaccoid = tobaccoid;
        this.userid = userid;
        this.createdate = createdate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
