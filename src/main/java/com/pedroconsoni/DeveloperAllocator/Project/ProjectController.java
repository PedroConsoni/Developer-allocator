package com.pedroconsoni.DeveloperAllocator.Project;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
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
    public ProjectModel createProject(@RequestBody ProjectModel projectModel) {
        return projectService.createProject(projectModel);
    }

    // List all registered projects
    @GetMapping("/list")
    public List<ProjectModel> listProject() { return projectService.listProject(); }

    // List registered projects by ID
    @GetMapping("/list/{id}")
    public ProjectModel listProjectsByID(@PathVariable Long id) { return projectService.listProjectByID(id); }

    // Change project data
    @PutMapping("/changeid")
    public String changeProject() {
        return "Change project by ID";
    }

    // Delete project
    @DeleteMapping("/deleteid")
    public String deleteProject() {
        return "Project delete by ID";
    }


}
