package com.cs.tobaccosystem.service;

import com.cs.tobaccosystem.bean.Tobacco;
import com.cs.tobaccosystem.dao.TobaccoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TobaccoService {
    @Autowired
    TobaccoDao tobaccoDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Tobacco> findAll(){
        return tobaccoDao.findAll();
    }

    public Tobacco findById(int id){
        return tobaccoDao.findById(id).orElse(new Tobacco(-1,"null",-1,-1));
    }

    public Tobacco findByName(String name) {
        return tobaccoDao.findByName(name);
    }

    public List<Tobacco> findBySupportId(int id){
        return tobaccoDao.findAllBySupportid(id);
    }

    public Tobacco updateTobacco(Tobacco tobacco){
        return tobaccoDao.save(tobacco);
    }

    public Tobacco addTobacco(Tobacco tobacco){
        Tobacco current = findById(tobacco.getTobaccoid());
        if(current.getSupportid() > -1)
            return current;
        else
            return tobaccoDao.save(tobacco);
    }

    public void deleteById(int id){
        String sql="delete from tobacco where tobaccoid=?;";
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0;");
        jdbcTemplate.update(sql,id);
//        return jdbcTemplate.update(sql,id);
    }

//    public Tobacco deleteById(int id){
//        Tobacco currnet = findById(id);
//        if(currnet.getSupportid() > -1){
//            tobaccoDao.deleteById(id);
//        }
//        return  currnet;
//    }
}
