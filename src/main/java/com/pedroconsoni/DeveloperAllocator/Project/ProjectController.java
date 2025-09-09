package com.pedroconsoni.DeveloperAllocator.Project;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperController;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperDTO;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO project = projectService.createProject(projectDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Project created successfully: " + project.getName());
    }

    // List all registered projects
    @GetMapping("/list")
    public ResponseEntity<List<ProjectDTO>> listProject() {
        List<ProjectDTO> projects = projectService.listProject();
        return ResponseEntity.ok(projects);
    }

    // List registered projects by ID
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listProjectsByID(@PathVariable Long id) {
        ProjectDTO project = projectService.listProjectByID(id);

        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project not found");
        }
    }

    // Update project data
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProjectByID(@PathVariable Long id, @RequestBody ProjectDTO updatedProject) {
        ProjectDTO project = projectService.updateProjectByID(id, updatedProject);

        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project not found");
        }
    }

    // Delete project
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProjectByID(@PathVariable Long id) {
        if (projectService.listProjectByID(id) != null) {
            projectService.deleteProjectByID(id);
            return ResponseEntity.ok("Project with ID: " + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID: " + id + " was not found");
        }
    }


}
