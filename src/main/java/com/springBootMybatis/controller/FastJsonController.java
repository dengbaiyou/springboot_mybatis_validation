package com.springBootMybatis.controller;

import com.github.pagehelper.PageHelper;
import com.springBootMybatis.mapper.UserMapper;
import com.springBootMybatis.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 传输json的Controller,注意实体类要有相应的getter,setter方法，不然返回{}；
 */
@RestController
public class FastJsonController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/show")
    public User show(){
        User user = userMapper.selectByPrimaryKey(1);
        return user;
    }

    @RequestMapping("/showPage")
    public List<User> showPage() {

        PageHelper.startPage(1, 5);
        List<User> users = userMapper.selectAll();
        return users;
    }
}
