package system.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import system.domain.User;
import system.service.trainService;
import system.service.userService;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userservice;

    @RequestMapping("/login")
    public String login(HttpSession session, @Param("user_id") String user_id,@Param("user_password") String user_password){
        User user = userservice.selectByUser_id(user_id);
        if(user.getUser_password().equals(user_password)){
            session.setAttribute("user",user);

        }
        System.out.println(user);
        return "redirect:/train/selectOther1";




    }
    @RequestMapping("/")
    public String loginview(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(User user, HttpSession session){
        System.out.println(user);
        if(userservice.selectByUser_id(user.getUser_id())==null) {
            userservice.insertUser(user);
            session.setAttribute("msg_insertUser", "注册成功！");

        }
        else {
            session.setAttribute("msg_insertUser", "该用户ID已被占用");

        }
        return "register";



    }
    @RequestMapping("/insertUser")
    public String insertUser(){
        return "register";
    }

}
