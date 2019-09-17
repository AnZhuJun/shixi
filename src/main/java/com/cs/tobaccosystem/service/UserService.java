package com.cs.tobaccosystem.service;

import com.cs.tobaccosystem.bean.User;
import com.cs.tobaccosystem.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(int id){
        return userDao.findById(id).orElse(new User(-1,"null","null","null","null",-1));
    }

    public List<User> findByOrderId(int id){
        return userDao.findAllByOrOrderid(id);
    }

    public List<User> findByName(String name){
        return userDao.findAllByName(name);
    }

    public User deleteById(int id){
        User current = findById(id);
        if(current.getUserid() > -1) {
            userDao.deleteById(id);
        }
        return current;
    }

    public User add(User user){
        return userDao.save(user);
    }

    public User update(User user){
        return userDao.save(user);
    }
}
