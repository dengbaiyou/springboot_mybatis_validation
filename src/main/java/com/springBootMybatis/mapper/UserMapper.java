package com.springBootMybatis.mapper;

import com.springBootMybatis.pojo.User;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

}