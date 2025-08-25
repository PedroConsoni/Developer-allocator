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
    private ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
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
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        ProjectModel project = projectMapper.map(projectDTO);
        project = projectRepository.save(project);
        return projectMapper.map(project);
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
