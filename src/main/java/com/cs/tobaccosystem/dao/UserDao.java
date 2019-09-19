package com.cs.tobaccosystem.dao;

import com.cs.tobaccosystem.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);
    User findByUsername(String name);
}
