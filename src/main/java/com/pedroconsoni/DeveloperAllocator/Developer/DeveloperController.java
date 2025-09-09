package com.pedroconsoni.DeveloperAllocator.Developer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO developer = developerService.createDeveloper(developerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Developer created successfully: " + developer.getName());
    }

    // List all registered developers
    @GetMapping("/list")
    public ResponseEntity<List<DeveloperDTO>> listDeveloper() {
        List<DeveloperDTO> developers = developerService.listDeveloper();
        return ResponseEntity.ok(developers);
    }

    // List registered developers by ID
    @GetMapping("/list/{id}")
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
