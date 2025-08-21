package com.pedroconsoni.DeveloperAllocator.Project;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
