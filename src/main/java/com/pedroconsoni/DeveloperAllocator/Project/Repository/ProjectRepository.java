package com.pedroconsoni.DeveloperAllocator.Project.Repository;

import com.pedroconsoni.DeveloperAllocator.Project.Model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {


}
