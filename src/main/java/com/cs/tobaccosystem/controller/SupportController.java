package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Support;
import com.cs.tobaccosystem.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
