package com.shital.SpringSecurityDemo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/start")
    public String m1()
    {
        return "start-quiz";
    }

    @GetMapping("/yes")
    public String m2()
    {
        return "yes";
    }
}
