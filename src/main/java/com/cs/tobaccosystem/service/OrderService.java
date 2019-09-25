package com.cs.tobaccosystem.service;

import com.cs.tobaccosystem.bean.Order;
import com.cs.tobaccosystem.dao.OrderDao;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Order> findAll(){
        return orderDao.findAll();
    }

    public Order findById(int id){
        return orderDao.findById(id).orElse(new Order(-1,-1,-1,null));
    }

    public Order add(Order order){
        Order current = findById(order.getOrderid());
        if(current.getOrderid() > -1)
            return current;
        else
            return orderDao.save(order);
    }

    public Order update(Order order){
        return orderDao.save(order);
    }

//    public Order deleteById(int id){
//        Order current = findById(id);
//        if(current.getOrderid() > -1){
//            orderDao.deleteById(id);
//        }
//        return current;
//    }

    public void deleteById(int id){
        String sql="delete from orders where orderid=?;";
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0;");
        jdbcTemplate.update(sql,id);
    }
}
