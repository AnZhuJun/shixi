package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Support;
import com.cs.tobaccosystem.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportController {
    @Autowired
    SupportService supportService;

    @GetMapping("/all")
    public List<Support> getAllSupport(){
        return supportService.findAll();
    }

    @GetMapping("/id/{id}")
    public Support getById(@PathVariable int id){
        return supportService.findByID(id);
    }

    @GetMapping("/name/{name}")
    public Support getByName(@PathVariable String name){
        return supportService.findByName(name);
    }

    @PostMapping("/update/{id}")
    public Support update(@PathVariable int id,@RequestBody Support support){
        support.setSupportid(id);
        return supportService.updateSupport(support);
    }

    @PutMapping("/add")
    public Support add(@RequestBody Support support){
        return supportService.addSupport(support);
    }

    @DeleteMapping("/delete/{id}")
    public Support delete(@PathVariable int id){
        return supportService.deleteSupportById(id);
    }
}
