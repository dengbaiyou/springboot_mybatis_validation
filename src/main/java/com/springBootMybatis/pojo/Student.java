package com.springBootMybatis.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String name;
    private Integer age;
    private List<String> cources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getCources() {
        return cources;
    }

    public void setCources(List<String> cources) {
        this.cources = cources;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cources=" + cources +
                '}';
    }
}
