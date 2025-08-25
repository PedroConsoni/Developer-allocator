package com.pedroconsoni.DeveloperAllocator.Project;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private final DeveloperRepository developerRepository;

    public ProjectService(DeveloperRepository developerRepository, ProjectRepository projectRepository) {
        this.developerRepository = developerRepository;
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

    // Create new project
    public ProjectModel createProject(ProjectModel projectModel) {
        return projectRepository.save(projectModel);
    }

    // Delete project by ID
    public void deleteProjectByID(Long id) {
        projectRepository.deleteById(id);
    }

    // Update project
    public ProjectModel updateProjectByID(Long id, ProjectModel updatedProject) {
        if (projectRepository.existsById(id)) {
            updatedProject.setId(id);
            return projectRepository.save(updatedProject);
        }
        return null;
    }
}
