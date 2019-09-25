package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.bean.User;
import com.cs.tobaccosystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @RequestMapping("/user")
    public String user(ModelMap modelMap){
        List<User> users = userService.findAll();
        modelMap.put("users",users);
        return "user";
    }

    @PostMapping("/user")
    public String addAndGetTobacco(String name, String username, String telephone,boolean isManager, ModelMap map){
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setTelephone(telephone);
        user.setManager(isManager);
        userService.save(user);

        List<User> users =userService.findAll();
        map.put("users",users);
        return "user";
    }

    @PostMapping("/delete")
    public String delete(int UserId,ModelMap map){
        userService.deleteById(UserId);

        List<User> users =userService.findAll();
        map.put("users",users);
        return "user";
    }
}
