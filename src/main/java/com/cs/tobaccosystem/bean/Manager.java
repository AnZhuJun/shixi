package com.cs.tobaccosystem.bean;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerid;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Transient
    private String passwordconfir;

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordconfir() {
        return passwordconfir;
    }

    public void setPasswordconfir(String passwordconfir) {
        this.passwordconfir = passwordconfir;
    }
}
