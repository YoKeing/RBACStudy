package com.RBAC.atcrowdfunding.controller;

import com.RBAC.atcrowdfunding.bean.AJAXResult;
import com.RBAC.atcrowdfunding.bean.Page;
import com.RBAC.atcrowdfunding.bean.User;
import com.RBAC.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/assign")
    public String assign(Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "user/assign";
    }

    @RequestMapping("/deletes")
    @ResponseBody
    public Object deletes(Integer[] userid){
        AJAXResult result = new AJAXResult();

        try {

            Map<String, Object> map = new HashMap<>();
            map.put("userids", userid);
            userService.deleteUsers(map);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;

    }

    @RequestMapping("/delete")
    @ResponseBody
    private Object delete(Integer id){
        AJAXResult result = new AJAXResult();

        try{
            userService.deleteUserById(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    private Object update(User user){
        AJAXResult result = new AJAXResult();

        try {
            userService.updateUser(user);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }


    @RequestMapping("/edit")
    public String edit(Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(User user){

        AJAXResult result = new AJAXResult();

        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setUserpswd("123456");
            user.setCreatetime(simpleDateFormat.format(new Date()));
            userService.insertUser(user);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/pageQuery")
    @ResponseBody
    public Object pageQuery(String queryText, Integer pageno, Integer pagesize){
        AJAXResult result = new AJAXResult();

        try{
            Map<String, Object> map = new HashMap<>();
            map.put("start", (pageno - 1) * pagesize);
            map.put("size", pagesize);
            map.put("queryText" ,queryText);

            List<User> users = userService.pageQueryData(map);

            int totalsize = userService.pageQueryCount(map);
            int totalno = 0;
            if(totalsize % pagesize == 0){
                totalno = totalsize / pagesize;
            }else{
                totalno = totalsize / pagesize + 1;
            }

            Page<User> userPage = new Page<User>(users, pageno,totalno, totalsize);

            result.setData(userPage);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }


    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping("/index1")
    public String index1(@RequestParam(required = false, defaultValue = "1") Integer pageno, @RequestParam(required = false, defaultValue = "2") Integer pagesize, Model model){

        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageno - 1) * pagesize);
        map.put("size", pagesize);

        List<User> users = userService.pageQueryData(map);
        model.addAttribute("users", users);

        model.addAttribute("pageno", pageno);
        int totalsize = userService.pageQueryCount(map);
        int totalno = 0;
        if(totalsize % pagesize == 0){
            totalno = totalsize / pagesize;
        }else{
            totalno = totalsize / pagesize + 1;
        }
        model.addAttribute("totalno", totalno);

        return "user/index";
    }

}
