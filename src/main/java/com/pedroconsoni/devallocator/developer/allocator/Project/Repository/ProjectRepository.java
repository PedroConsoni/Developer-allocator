package com.pedroconsoni.devallocator.developer.allocator.Project.Repository;

import com.pedroconsoni.devallocator.developer.allocator.Project.Model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
}
