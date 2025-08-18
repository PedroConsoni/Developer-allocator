package com.pedroconsoni.DeveloperAllocator.Project.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
public class ProjectController {

    // Add project
    @PostMapping("/add")
    public String createProject() {
        return "Project add";
    }

    // List all registered projects
    @GetMapping("/showall")
    public String showProject() {
        return "Show all project";
    }

    // List registered projects by ID
    @GetMapping("/showid")
    public String showDevelopersByID() {
        return "Show developers by id";
    }

    // Change project data
    @PutMapping("/changeid")
    public String changeProject() {
        return "Change developers by ID";
    }

    // Delete project
    @DeleteMapping("/deleteid")
    public String deleteProject() {
        return "Developer delete by ID";
    }


}
