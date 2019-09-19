package com.cs.tobaccosystem.dao;

import com.cs.tobaccosystem.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
}
