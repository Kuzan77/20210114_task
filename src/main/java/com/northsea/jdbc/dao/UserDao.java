package com.northsea.jdbc.dao;

import com.northsea.jdbc.pojo.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void mod(User user);
    public void del(String uid);
    public User load(String uid);
    public List<User> findAll();
}
