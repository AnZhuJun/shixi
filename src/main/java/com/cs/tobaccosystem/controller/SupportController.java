package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Support;
import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @PostMapping("/delete")
    public String delete(int SupportId,ModelMap map){
        supportService.deleteSupportById(SupportId);

        List<Support> supports =supportService.findAll();
        map.put("supports",supports);
        return "support";
    }

    @RequestMapping("/support")
    public String support(ModelMap modelMap){
        List<Support> supports = supportService.findAll();
        modelMap.put("supports",supports);
        return "support";
    }

    @PostMapping("/support")
    public String addAndGetSupport(String name, String telephone,String information, ModelMap map){
        Support support = new Support();
        support.setName(name);
        support.setTelephone(telephone);
        support.setInformation(information);
        supportService.addSupport(support);

        List<Support> supports =supportService.findAll();
        map.put("supports",supports);
        return "support";
    }
}
