package com.northsea.UserLogin.dao.Impl;

import com.northsea.UserLogin.dao.UserDao;
import com.northsea.UserLogin.pojo.User;

import java.io.*;

public class UserDaoImpl implements UserDao {
    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     * @throws IOException
     */
    @Override
    public boolean Login(String userName, String passWord) throws IOException {
        // 创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        // 用来记录用户信息在文件中存不存在
        boolean flag = false;
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] str = line.split("&");
            if (str[0].equals(userName) && str[1].equals(passWord)) {
                flag = true;
            }
        }
        // 释放资源
        br.close();
        return flag;
    }

    /**
     * 注册
     * @param user
     * @throws IOException
     */
    @Override
    public void Register(User user) throws IOException {
        if (user != null) {
            boolean flag = queryUser(user.getUsername());
            if (flag == true) {
                System.out.println("用户已存在");
            }else {
                // 创建字符缓冲输出流对象
                BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true));
                //把用户信息存进文件里
                String info = user.getUsername()+"&"+user.getPassword();
                bw.write(info);
                bw.newLine();
                //刷新缓冲区
                bw.flush();
                // 关闭资源
                bw.close();

                System.out.println("注册成功!!!");
            }
        }else {
            System.out.println("注册失败: 用户名信息不能为空!!!");
        }
    }

    /**
     * 注册之前查询用户是否已存在
     * @param userName
     * @return
     * @throws IOException
     */
    public boolean queryUser(String userName) throws IOException {
        // 创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        // 用来记录用户信息在文件中存不存在
        boolean flag = false;
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] str = line.split("&");
            if (str[0].equals(userName)) {
                flag = true;
            }
        }
        br.close();
        return flag;
    }
}
