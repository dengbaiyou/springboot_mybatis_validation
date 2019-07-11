package com.springBootMybatis.controller;

import com.springBootMybatis.pojo.User;
import com.springBootMybatis.pojo.UserResult;
import com.springBootMybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add() {
        return "user::add";
    }

    @PostMapping("/save")
    @ResponseBody
    public UserResult save(@Valid User user, BindingResult bindingResult) {

        /**
         * 使用 BindingResult 判断是否验证成功，如果有错误信息，
         * 拿到错误信息，封装，返回
         */
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : fieldErrors) {
                sb.append(fe.getDefaultMessage()).append("<br>");
            }
            UserResult ur = new UserResult();
            ur.setMsg(sb.toString());
            return ur;
        }
        int i = userService.save(user);
        UserResult ur = new UserResult();
        if (i > 0) {
            ur.setCode("0");
            ur.setMsg("添加成功");
        } else {
            ur.setCode("-1");
            ur.setMsg("添加失败");
        }
        return ur;
    }

    @PostMapping("/list")
    public String list(HttpServletRequest request) {
        int pageNum = 1;
        int pageSize = 10;
        request.setAttribute("users", userService.find(pageNum, pageSize));
        return "user::list";
    }

}
