package com.cuisf.controller;

import com.cuisf.entity.Account;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Controller
public class AccountControler {


    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){

        return url;
    }

    @PostMapping("/login")
    public String login(String username,String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            Account account = (Account) subject.getPrincipal();
            subject.getSession().setAttribute("account",account);
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("账号异常");
            model.addAttribute("msg","账号异常");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("msg","密码异常");
            System.out.println("密码异常");
            return "login";
        }
    }

    @GetMapping("/unauthc")
    @ResponseBody
    public String unauthc(){

        return "未授权";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }

}

