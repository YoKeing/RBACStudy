package com.RBAC.atcrowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @RequestMapping("/index")
    public String index(){

        return "permission/index";
    }

}
