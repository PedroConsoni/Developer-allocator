package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    // Create developer
    @PostMapping("/create")
    public String createDeveloper() { return "Developer create"; }

    // List all registered developers
    @GetMapping("/list")
    public List<DeveloperModel> listDeveloper() { return developerService.listDeveloper(); }

    // List registered developers by ID
    @GetMapping("/listid")
    public String listDeveloperByID() { return "List developer by id"; }

    // Change developer data
    @PutMapping("/changeid")
    public String changeDeveloperByID() { return "Change developer by id"; }

    // Delete developer
    @DeleteMapping("/deleteid")
    public String deleteByID() { return "Developer delete by ID"; }

}
