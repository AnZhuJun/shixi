package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Order;
import com.cs.tobaccosystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @GetMapping("/id/{id}")
    public Order findById(@PathVariable int id){
        return orderService.findById(id);
    }

    @PutMapping("/add")
    public Order add(@RequestBody Order order){
        return orderService.add(order);
    }

    @PostMapping("/update/{id}")
    public Order update(@PathVariable int id,@RequestBody Order order){
        order.setOrderid(id);
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public Order delete(@PathVariable int id){
        return orderService.deleteById(id);
    }
}
