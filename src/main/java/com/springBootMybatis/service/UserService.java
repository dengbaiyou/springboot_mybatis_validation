package com.springBootMybatis.service;

import com.springBootMybatis.pojo.User;

import java.util.List;

public interface UserService {

    int save(User user);

    List<User> find(Integer pageNum, Integer pageSize);
}
