package com.pedroconsoni.DeveloperAllocator.Developer;

import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

    public DeveloperModel map(DeveloperDTO developerDTO) {
        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setId(developerDTO.getId());
        developerModel.setEmail(developerDTO.getEmail());
        developerModel.setName(developerDTO.getName());
        developerModel.setAge(developerDTO.getAge());
        developerModel.setProject(developerDTO.getProject());
        return developerModel;
    }

    public DeveloperDTO map(DeveloperModel developerModel) {
        DeveloperDTO developerDTO = new DeveloperDTO();
        developerDTO.setId(developerModel.getId());
        developerDTO.setEmail(developerModel.getEmail());
        developerDTO.setName(developerModel.getName());
        developerDTO.setAge(developerModel.getAge());
        developerDTO.setProject(developerModel.getProject());
        return developerDTO;
    }

    public void updateDeveloperFromDto(DeveloperDTO dto, DeveloperModel entity) {
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getAge() != null) {
            entity.setAge(dto.getAge());
        }
        if (dto.getProject() != null) {
            entity.setProject(dto.getProject());
        }
    }
}
