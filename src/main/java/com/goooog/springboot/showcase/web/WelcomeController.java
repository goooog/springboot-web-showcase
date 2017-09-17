package com.goooog.springboot.showcase.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by young on 2017/9/17.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message","Hello world");
        return "welcome";
    }
}
