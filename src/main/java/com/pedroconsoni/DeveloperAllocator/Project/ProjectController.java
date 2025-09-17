package com.pedroconsoni.DeveloperAllocator.Project;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperController;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperDTO;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;

    }

    // Create project
    @PostMapping("/create")
    @Operation(summary = "Projects creation", description = "This route creates the projects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "409", description = "Existing resource"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<String> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO project = projectService.createProject(projectDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Project created successfully: " + project.getName());
    }

    // List all registered projects
    @GetMapping("/list")
    @Operation(summary = "List all projects", description = "This route lists all projects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<List<ProjectDTO>> listProject() {
        List<ProjectDTO> projects = projectService.listProject();
        return ResponseEntity.ok(projects);
    }

    // List registered projects by ID
    @GetMapping("/list/{id}")
    @Operation(summary = "List projects by ID", description = "This route lists projects by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
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
    @Operation(summary = "Updates projects by ID", description = "This route updates projects by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "204", description = "Update successful but no response body"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
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
    @Operation(summary = "Delete projects by ID", description = "This route deletes projects by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Resource deleted successfully"),
            @ApiResponse(responseCode = "204", description = "Update successful but no response body"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
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
