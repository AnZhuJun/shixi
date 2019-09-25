package com.cs.tobaccosystem.dao;

import com.cs.tobaccosystem.bean.Tobacco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TobaccoDao extends JpaRepository<Tobacco,Integer> {
    Tobacco findByName(String name);
    List<Tobacco> findAllBySupportid(int supportid);

}
