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
    public DeveloperDTO createDeveloper(@RequestBody DeveloperDTO developerDTO) { return developerService.createDeveloper(developerDTO); }

    // List all registered developers
    @GetMapping("/list")
    public List<DeveloperModel> listDeveloper() { return developerService.listDeveloper(); }

    // List registered developers by ID
    @GetMapping("/list/{id}")
    public DeveloperModel listDeveloperByID(@PathVariable Long id) { return developerService.listDeveloperByID(id); }

    // Update developer data
    @PutMapping("/update/{id}")
    public DeveloperModel updateDeveloperByID(@PathVariable Long id, @RequestBody DeveloperModel updatedDeveloper) { return developerService.updateDeveloperByID(id, updatedDeveloper); }

    // Delete developer
    @DeleteMapping("/delete/{id}")
    public void deleteDeveloperByID(@PathVariable Long id) { developerService.deleteDeveloperByID(id); }

}
