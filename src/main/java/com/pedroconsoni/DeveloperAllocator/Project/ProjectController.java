package com.pedroconsoni.DeveloperAllocator.Project.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
public class ProjectController {

    // Create project
    @PostMapping("/create")
    public String createProject() {
        return "Create Project";
    }

    // List all registered projects
    @GetMapping("/list")
    public String listProject() {
        return "List project";
    }

    // List registered projects by ID
    @GetMapping("/listid")
    public String listDevelopersByID() {
        return "List developer by id";
    }

    // Change project data
    @PutMapping("/changeid")
    public String changeProject() {
        return "Change developer by ID";
    }

    // Delete project
    @DeleteMapping("/deleteid")
    public String deleteProject() {
        return "Developer delete by ID";
    }


}
