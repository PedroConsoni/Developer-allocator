package com.pedroconsoni.DeveloperAllocator.Project;

import com.pedroconsoni.DeveloperAllocator.Project.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {


}
