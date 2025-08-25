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
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    // List all registered projects
    @GetMapping("/list")
    public List<ProjectModel> listProject() { return projectService.listProject(); }

    // List registered projects by ID
    @GetMapping("/list/{id}")
    public ProjectModel listProjectsByID(@PathVariable Long id) { return projectService.listProjectByID(id); }

    // Update project data
    @PutMapping("/update/{id}")
    public ProjectModel updateProjectByID(@PathVariable Long id, @RequestBody ProjectModel updatedProject) {
        return projectService.updateProjectByID(id, updatedProject);
    }

    // Delete project
    @DeleteMapping("/delete/{id}")
    public void deleteProjectByID(@PathVariable Long id) {
        projectService.deleteProjectByID(id);
    }


}
