package com.cs.tobaccosystem.dao;

import com.cs.tobaccosystem.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {

}
