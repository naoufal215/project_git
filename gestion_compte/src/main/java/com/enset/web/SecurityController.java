package com.enset.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by naoufal on 23/02/2017.
 */
@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/")
    public String home(){
        return "redirect:/operations";
    }
    @RequestMapping("/403")
    public String accessDenied(){
        return "403";
    }
}
