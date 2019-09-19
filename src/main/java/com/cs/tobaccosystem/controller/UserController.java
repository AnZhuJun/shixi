package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.User;
import com.cs.tobaccosystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/find/all")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public User getById(@PathVariable int id){
        return userService.findById(id);
    }



    @GetMapping("/find/name/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @PutMapping("/add")
    public void add(@RequestBody User user){
         userService.save(user);
    }

    @PostMapping("/update/{id}")
    public User update(@PathVariable int id,@RequestBody User user){
        user.setUserid(id);
        return userService.update(user);
    }
}
