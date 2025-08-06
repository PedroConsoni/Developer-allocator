package com.pedroconsoni.devallocator.developer.allocator.Developer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DeveloperController {

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Tony stark";
    }
}
