package com.northsea.UserLogin.dao;

import com.northsea.UserLogin.pojo.User;

import java.io.IOException;

public interface UserDao {
    public abstract boolean userLogin(String userName, String passWord);
    public abstract void userRegister(User user);
    public abstract boolean queryUser(String userName);
}
