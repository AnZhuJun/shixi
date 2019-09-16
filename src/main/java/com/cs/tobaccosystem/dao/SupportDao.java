package com.cs.tobaccosystem.dao;


import com.cs.tobaccosystem.bean.Support;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportDao extends JpaRepository<Support,Integer> {
    Support findByName(String name);
}
