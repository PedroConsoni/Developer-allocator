package com.pedroconsoni.devallocator.developer.allocator.Developer.Repository;

import com.pedroconsoni.devallocator.developer.allocator.Developer.Model.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository< DeveloperModel, Long > {


}
