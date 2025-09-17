package com.pedroconsoni.DeveloperAllocator.Project;

import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperDTO;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectModel map(ProjectDTO projectDTO) {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setId(projectDTO.getId());
        projectModel.setName(projectDTO.getName());
        projectModel.setDifficulty(projectDTO.getDifficulty());
        projectModel.setType(projectDTO.getType());
        projectModel.setDeveloper(projectDTO.getDeveloper());

        return projectModel;
    }

    public ProjectDTO map(ProjectModel projectModel) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectModel.getId());
        projectDTO.setName(projectModel.getName());
        projectDTO.setDifficulty(projectModel.getDifficulty());
        projectDTO.setType(projectModel.getType());
        projectDTO.setDeveloper(projectModel.getDeveloper());

        return projectDTO;
    }

    public void updateProjectFromDto(ProjectDTO dto, ProjectModel entity) {
        if (dto.getDifficulty() != null) {
            entity.setDifficulty(dto.getDifficulty());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getType() != null) {
            entity.setType(dto.getType());
        }
        if (dto.getDeveloper() != null) {
            entity.setDeveloper(dto.getDeveloper());
        }
    }
}
