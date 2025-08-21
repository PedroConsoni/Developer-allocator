package com.pedroconsoni.DeveloperAllocator.Project;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // List all projects
    public List<ProjectModel> listProject() {
        return projectRepository.findAll();
    }

    // List projects by ID
    public ProjectModel listProjectByID(Long id) {
        Optional<ProjectModel> projectByID = projectRepository.findById(id);
        return projectByID.orElse(null);
    }
}
