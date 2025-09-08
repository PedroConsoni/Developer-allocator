package com.pedroconsoni.DeveloperAllocator.Project;

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
}
