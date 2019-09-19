package com.cs.tobaccosystem.dao;

import com.cs.tobaccosystem.bean.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerDao extends JpaRepository<Manager,Integer> {
    Manager findByUsername(String name);
}
