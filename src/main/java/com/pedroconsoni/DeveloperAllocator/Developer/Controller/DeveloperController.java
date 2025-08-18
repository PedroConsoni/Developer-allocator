package com.pedroconsoni.DeveloperAllocator.Developer.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping


public class DeveloperController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // Add developer
    @PostMapping("/add")
    public String addDeveloper() {
        return "Developer add";
    }

    // List all registered developers
    @GetMapping("/all")
    public String showAllDevelopers() {
        return "Show all developers";
    }

    // List registered developers by ID
    @GetMapping("/allid")
    public String showDevelopersByID() {
        return "show developers by id";
    }

    // Change developer data
    @PutMapping("/changeid")
    public String changeDevelopersByID() {
        return "Change developers by id";
    }

    // Delete developer
    @DeleteMapping("/deleteid")
    public String deleteByID() {
        return "Developer delete by ID";
}

}
