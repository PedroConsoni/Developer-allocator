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
        developerDTO.setAge(developerDTO.getAge());
        developerDTO.setProject(developerModel.getProject());

        return developerDTO;
    }
}
