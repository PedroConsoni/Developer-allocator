package com.pedroconsoni.DeveloperAllocator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping


public class DeveloperController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
