package com.example.ace.controller;

import com.example.ace.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * <p>Title:UserCtrl.java</p >
 * <p>Description:controller</p >
 *
 * @author Sephinor
 * @version 1.0
 * @time 2019/11/25 20:15
 */
@RestController
public class UserCtrl {

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser(){
        User user = new User("123@11.com","wx","123456","11","123");
        System.err.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    //将session存入redis中实现session共享
    @RequestMapping("/uid")
    String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }

    @RequestMapping("/login")
    public String login (HttpServletRequest request,String userName ,String password){
        String msg = "----login failure----";
        User user = new User();
        user.setUserName("wx");
        user.setPassword("123");

        if( password.equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            msg = "----login success----";
        }
        return msg;

    }

}
