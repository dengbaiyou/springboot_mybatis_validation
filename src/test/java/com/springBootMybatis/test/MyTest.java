package com.springBootMybatis.test;

import com.springBootMybatis.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    Student student;
    @Test
    public void demo(){
        System.out.println(student);
    }
}
