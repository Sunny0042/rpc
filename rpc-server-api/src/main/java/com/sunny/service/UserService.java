package com.sunny.service;

import com.sunny.bean.User;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 15:26
 * @ModifyDate 2019-09-19 15:26
 */
public interface UserService {

    String sayHello(String name);

    User saveUser(User user);
}
