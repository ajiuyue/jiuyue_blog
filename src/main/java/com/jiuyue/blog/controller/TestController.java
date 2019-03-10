package com.jiuyue.blog.controller;
import com.jiuyue.blog.pojo.model.Users;
import com.jiuyue.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create bySeptember
 * 2019/3/7
 * 13:31
 */
@Controller
public class TestController {
    @Autowired
    private UsersService usersService;

    @ResponseBody
    @RequestMapping("/")
    public String test(){
        return "springboot jiuyue blog";
    }


    @RequestMapping("blog/getUsers")
    public String getUsers(){
        Users users = usersService.getUsers(1);
        System.out.println(users);
        return "userList";
    }
}
