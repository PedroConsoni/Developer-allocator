package com.pedroconsoni.DeveloperAllocator.Developer.Repository;

import com.pedroconsoni.DeveloperAllocator.Developer.Model.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<DeveloperModel, Long> {
}
