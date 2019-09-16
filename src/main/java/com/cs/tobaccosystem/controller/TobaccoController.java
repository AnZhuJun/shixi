package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.dao.TobaccoDao;
import com.cs.tobaccosystem.service.TobaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tobacco")
public class TobaccoController {
    @Autowired
    TobaccoService tobaccoService;

    @GetMapping("/all")
    public List<Tobacco> getAllTobacco(){
        return tobaccoService.findAll();
    }

    @GetMapping("/id/{id}")
    public Tobacco getById(@PathVariable int id){
        return tobaccoService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Tobacco getByName(@PathVariable String name){
        return tobaccoService.findByName(name);
    }

    @GetMapping("/supportid/{id}")
    public List<Tobacco> getBySupportId(@PathVariable int id){
        return tobaccoService.findBySupportId(id);
    }

    @PostMapping("/update/{id}")
    public Tobacco update(@PathVariable int id,@RequestBody Tobacco tobacco){
        tobacco.setTobaccoid(id);
        return tobaccoService.updateTobacco(tobacco);
    }

    @PutMapping("/add")
    public Tobacco add(@RequestBody Tobacco tobacco){

        return tobaccoService.addTobacco(tobacco);
    }

    @DeleteMapping("/delete/{id}")
    public Tobacco delete(@PathVariable int id){
        return tobaccoService.deleteById(id);
    }
}
