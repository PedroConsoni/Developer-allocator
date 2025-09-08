package com.pedroconsoni.DeveloperAllocator.Project;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    // List all projects
    public List<ProjectDTO> listProject() {
        List<ProjectModel> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::map)
                .collect(Collectors.toList());
    }

    // List projects by ID
    public ProjectDTO listProjectByID(Long id) {
        Optional<ProjectModel> projectByID = projectRepository.findById(id);
        return projectByID.map(projectMapper::map).orElse(null);
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
    public ProjectDTO updateProjectByID(Long id, ProjectDTO projectDTO) {
        Optional<ProjectModel> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            ProjectModel updatedProject = projectMapper.map(projectDTO);
            updatedProject.setId(id);
            ProjectModel projectSaved = projectRepository.save(updatedProject);
            return projectMapper.map(projectSaved);
        }
        return null;
    }
}
