package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.component.RedisComponent;
import com.cs.tobaccosystem.dao.TobaccoDao;
import com.cs.tobaccosystem.service.TobaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/tobacco")
public class TobaccoController {
    @Autowired
    TobaccoService tobaccoService;

    @Autowired
    RedisComponent redisComponent;

    @RequestMapping("/error")
    public String error(){
        throw new RuntimeException("test exception");
    }

    @GetMapping("/all")
    public List<Tobacco> getAllTobacco(){
        return tobaccoService.findAll();
    }

    @Cacheable(value = "tobacco",key = "#id")
    @GetMapping("/id/{id}")
    public Tobacco getById(@PathVariable int id){
        return tobaccoService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Tobacco getByName(@PathVariable String name) throws IOException {
        Tobacco tobacco =redisComponent.get("tobacco::"+name,Tobacco.class);
        if(Objects.isNull(tobacco)){
            tobacco = tobaccoService.findByName(name);
            redisComponent.set("tobacco::" + name,tobacco);
        }
        return tobacco;
    }

    @Cacheable(value = "tobacco",key = "#id")
    @GetMapping("/supportid/{id}")
    public List<Tobacco> getBySupportId(@PathVariable int id){
        return tobaccoService.findBySupportId(id);
    }

    @CachePut(value = "tobacco",key = "#id")
    @PutMapping("/update/{id}")
    public Tobacco update(@PathVariable int id,@RequestBody Tobacco tobacco){
        tobacco.setTobaccoid(id);
        return tobaccoService.updateTobacco(tobacco);
    }

    @PutMapping("/add")
    public Tobacco add(@RequestBody Tobacco tobacco){
        return tobaccoService.addTobacco(tobacco);
    }

    @RequestMapping("/tobacco")
    public String tobacco(ModelMap modelMap){
        List<Tobacco> tobaccos = tobaccoService.findAll();
        modelMap.put("tobaccos",tobaccos);
        return "tobacco";
    }

    @PostMapping("/tobacco")
    public String addAndGetTobacco(String name, int supportid, int price, ModelMap map){
        Tobacco tobacco = new Tobacco();
        tobacco.setName(name);
        tobacco.setSupportid(supportid);
        tobacco.setPrice(price);
        tobaccoService.addTobacco(tobacco);

        List<Tobacco> tobaccos =tobaccoService.findAll();
        map.put("tobaccos",tobaccos);
        return "tobacco";
    }

    @CacheEvict(value = "tobacco",allEntries = true)
    @DeleteMapping("/delete/{id}")
    public Tobacco delete(@PathVariable int id){
        return tobaccoService.deleteById(id);
    }
}
