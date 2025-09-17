package com.pedroconsoni.DeveloperAllocator.Developer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    // Create developer
    @PostMapping("/create")
    @Operation(summary = "Developers creation", description = "This route creates the developers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "409", description = "Existing resource"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<String> createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO developer = developerService.createDeveloper(developerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Developer created successfully: " + developer.getName());
    }

    // List all registered developers
    @GetMapping("/list")
    @Operation(summary = "List all developers", description = "This route lists all developers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<List<DeveloperDTO>> listDeveloper() {
        List<DeveloperDTO> developers = developerService.listDeveloper();
        return ResponseEntity.ok(developers);
    }

    // List registered developers by ID
    @GetMapping("/list/{id}")
    @Operation(summary = "List developers by ID", description = "This route lists developers by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<?> listDeveloperByID(@PathVariable Long id) {
        DeveloperDTO developer = developerService.listDeveloperByID(id);

        if (developer != null) {
            return ResponseEntity.ok(developer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Developer not found");
        }
    }

    // Update developer data
    @PutMapping("/update/{id}")
    @Operation(summary = "Updates developers by ID", description = "This route updates developers by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found and returned successfully"),
            @ApiResponse(responseCode = "204", description = "Update successful but no response body"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<?> updateDeveloperByID(@PathVariable Long id, @RequestBody DeveloperDTO updatedDeveloper) {
        DeveloperDTO developer = developerService.updateDeveloperByID(id, updatedDeveloper);

        if (developer != null) {
            return ResponseEntity.ok(developer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Developer not found");
        }
    }

    // Delete developer
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete developers by ID", description = "This route deletes developers by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Resource deleted successfully"),
            @ApiResponse(responseCode = "204", description = "Update successful but no response body"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent"),
            @ApiResponse(responseCode = "404", description = "Reported resource not found"),
            @ApiResponse(responseCode = "500", description = "Something unexpected happened on the server")
    })
    public ResponseEntity<String> deleteDeveloperByID(@PathVariable Long id) {
        if (developerService.listDeveloperByID(id) != null) {
            developerService.deleteDeveloperByID(id);
            return ResponseEntity.ok( "Developer with ID: " + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Developer with ID: " + id + " was not found");
        }
    }

}
