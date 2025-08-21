package com.pedroconsoni.DeveloperAllocator.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;

    }

    // Create project
    @PostMapping("/create")
    public String createProject() {
        return "Create Project";
    }

    // List all registered projects
    @GetMapping("/list")
    public List<ProjectModel> listProject() { return projectService.listProject(); }

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
