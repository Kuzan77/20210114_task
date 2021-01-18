package com.northsea.UserLogin.dao.Impl;

import com.northsea.UserLogin.dao.UserDao;
import com.northsea.UserLogin.pojo.User;

import java.io.*;

public class UserDaoImpl implements UserDao {
    // 为了保证文件一加载就创建
    private static File file = new File("user.txt");
    static {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("创建文件失败!!!");
        }
    }
    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     * @throws IOException
     */
    @Override
    public boolean userLogin(String userName, String passWord) {
        // 创建字符缓冲输入流对象
        BufferedReader br = null;
        boolean flag = false;
        try {
            br = new BufferedReader(new FileReader(file));
            // 用来记录用户信息在文件中存不存在
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("&");
                if (str[0].equals(userName) && str[1].equals(passWord)) {
                    flag = true;
                }
            }
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println("文件不存在!!!");
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("登录失败, 未查到用户信息");
        }finally {
            if (br != null) {
                try {
                    // 释放资源
                    br.close();
                } catch (IOException e) {
                    // e.printStackTrace();
                    System.out.println("释放资源失败!!!");
                }
            }
        }
        return flag;
    }

    /**
     * 注册
     * @param user
     * @throws IOException
     */
    @Override
    public void userRegister(User user)  {
        if (user != null) {
            boolean flag = false;
            try {
                flag = queryUser(user.getUsername());
                if (flag == true) {
                    System.out.println("用户已存在");
                }else {
                    // 创建字符缓冲输出流对象
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
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
            } catch (IOException e) {
                e.printStackTrace();
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
    public boolean queryUser(String userName) {
        // 创建字符缓冲输入流对象
        BufferedReader br = null;
        // 用来记录用户信息在文件中存不存在
        boolean flag = false;
        try {
            br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("&");
                if (str[0].equals(userName)) {
                    flag = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    // 释放资源
                    br.close();
                } catch (IOException e) {
                    // e.printStackTrace();
                    System.out.println("释放资源失败!!!");
                }
            }
        }
        return flag;
    }
}
