package com.example.springblog.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppRouteController {

    @GetMapping(value = {"/post/*", "/login", "/login/"})
    public String redirect() {
        return "forward:/";
    }

}
