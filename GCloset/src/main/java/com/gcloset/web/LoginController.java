package com.gcloset.web;

import com.gcloset.web.domain.cloth.Cloth;
import com.gcloset.web.domain.cloth.ClothService;
import com.gcloset.web.domain.user.User;
import com.gcloset.web.annotation.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private ClothService clothService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete(){
        return "loginSuccess";
    }
}
