package com.springBootMybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.springBootMybatis.mapper.UserMapper;
import com.springBootMybatis.pojo.User;
import com.springBootMybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> find(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAll();
    }
}
