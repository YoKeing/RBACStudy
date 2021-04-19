package com.RBAC.atcrowdfunding.controller;

import com.RBAC.atcrowdfunding.bean.AJAXResult;
import com.RBAC.atcrowdfunding.bean.User;
import com.RBAC.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Abyss
 */
@Controller
public class DispatcherController {


    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public String logout(HttpSession session){
//        session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(User user, Model model){


//        System.out.println(user);
        User dbUser = userService.query4Login(user);
        System.out.println(dbUser);

        if(dbUser != null){
            return "main";
        }else{
            String errorMsg = "登录账户或密码错误！请重新输入";
            model.addAttribute("errorMsg", errorMsg);
            return "redirect:login";
        }
//        return "main";
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session){

        AJAXResult result = new AJAXResult();
        User dbUser = userService.query4Login(user);

        if(dbUser != null){
            session.setAttribute("loginUser", dbUser);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/main")
    public String main(){
        return null;
    }

}
