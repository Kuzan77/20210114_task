package com.northsea.UserLogin.dao;

import com.northsea.UserLogin.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserDao {
    public abstract boolean Login(String userName, String passWord) throws IOException;
    public abstract void Register(User user) throws IOException;
    public abstract boolean queryUser(String userName) throws IOException;
}
