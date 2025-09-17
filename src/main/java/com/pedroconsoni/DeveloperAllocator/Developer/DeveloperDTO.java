package com.pedroconsoni.DeveloperAllocator.Developer;
import com.pedroconsoni.DeveloperAllocator.Project.ProjectModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDTO {

    Long id;
    private String email;
    private String name;
    private Integer age;
    private ProjectModel project;
}
