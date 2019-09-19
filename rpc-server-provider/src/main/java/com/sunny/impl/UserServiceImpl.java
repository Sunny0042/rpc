package com.sunny.impl;

import com.sunny.bean.User;
import com.sunny.service.UserService;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 15:30
 * @ModifyDate 2019-09-19 15:30
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        System.out.println("provider method 'sayHello' is invoked");
        System.out.println("name :" + name);
        return "SUCCESS";
    }

    @Override
    public User saveUser(User user) {
        System.out.println("provider method 'saveUser' is invoked");
        System.out.println(user);
        user.setAge(999);
        return user;
    }
}
