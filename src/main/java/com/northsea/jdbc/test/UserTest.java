package com.northsea.jdbc.test;

import com.northsea.jdbc.dao.UserDao;
import com.northsea.jdbc.dao.impl.UserDaoImpl;
import com.northsea.jdbc.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/23 16:29
 */
public class UserTest {

    UserDao userDao = new UserDaoImpl();

    /**
     * 添加用户
     */
    @Test
    public void addUser() {
        User user = new User("U_1003", "Jack", "123456");
        userDao.add(user);
    }

    /**
     * 修改用户信息
     */
    @Test
    public void updateUser() {
        User user = new User("U_1002", "KuZan", "123456");
        userDao.mod(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUserById() {
        String id = "U_1003";
        userDao.del(id);
    }

    /**
     * 根据ID查询用户
     */
    @Test
    public void selectById() {
        String id = "U_1002";
        User user = userDao.load(id);
        System.out.println(user.getUid());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    /**
     * 查询所有用户
     */
    @Test
    public void selectAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getUid() +"------"+ user.getUsername() +"------"+ user.getPassword());
        }
    }
}
