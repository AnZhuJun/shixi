package com.cs.tobaccosystem.service;

import com.cs.tobaccosystem.bean.User;
import com.cs.tobaccosystem.dao.RoleDao;
import com.cs.tobaccosystem.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(int id){
        return userDao.findById(id).orElse(new User(-1,"null","null","null","null",false));
    }

    public List<User> findByName(String name){
        return userDao.findAllByName(name);
    }

    public User findByUserName(String name){
        return userDao.findByUsername(name);
    }

    public User deleteById(int id){
        User current = findById(id);
        if(current.getUserid() > -1) {
            userDao.deleteById(id);
        }
        return current;
    }

    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleDao.findAll()));
        userDao.save(user);
    }

//    public User add(User user){
//        User current = findById(user.getUserid());
//        if(current.getUserid() > -1)
//            return current;
//        else
//            return userDao.save(user);
//    }

    public User update(User user){
        return userDao.save(user);
    }
}
