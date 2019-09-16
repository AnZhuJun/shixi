package com.cs.tobaccosystem.service;

import com.cs.tobaccosystem.bean.Support;
import com.cs.tobaccosystem.dao.SupportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {
    @Autowired
    SupportDao supportDao;

    public List<Support> findAll(){
        return supportDao.findAll();
    }

    public Support findByID(int id){
        return supportDao.findById(id).orElse(new Support(-1,"null"));
    }

    public Support findByName(String name){
        return supportDao.findByName(name);
    }

    public Support updateSupport(Support support){
        return supportDao.save(support);
    }

    public Support addSupport(Support support){
        return supportDao.save(support);
    }

    public Support deleteSupportById(int id){
        Support current = findByID(id);
        if(current.getSupportid() > -1){
            supportDao.deleteById(id);
        }
        return current;
    }
}
