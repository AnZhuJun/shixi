package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Order;
import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @PostMapping("/delete")
    public String delete(int OrderId, ModelMap map){
        orderService.deleteById(OrderId);

        List<Order> orders =orderService.findAll();
        map.put("orders",orders);
        return "order";
    }

    @RequestMapping("/order")
    public String order(ModelMap modelMap){
        List<Order> orders = orderService.findAll();
        modelMap.put("orders",orders);
        return "order";
    }

    @PostMapping("/order")
    public String addAndGetOrder(int tobaccoid, int userid,ModelMap map){
        Order order = new Order();
        order.setTobaccoid(tobaccoid);
        order.setUserid(userid);
        orderService.add(order);

        List<Order> orders =orderService.findAll();
        map.put("orders",orders);
        return "order";
    }
}
