package com.pedroconsoni.devallocator.developer.allocator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AllocatorController {

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Tony stark";
    }
}
