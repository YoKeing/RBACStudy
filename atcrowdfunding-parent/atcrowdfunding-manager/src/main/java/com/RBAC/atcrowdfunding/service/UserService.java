package com.RBAC.atcrowdfunding.service;

import com.RBAC.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);

    List<User> pageQueryData(Map<String, Object> map);


    int pageQueryCount(Map<String, Object> map);

    void insertUser(User user);

    User queryById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);

    void deleteUsers(Map<String, Object> map);
}
