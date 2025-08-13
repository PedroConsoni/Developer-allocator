package com.pedroconsoni.DeveloperAllocator.Project.Model;

import com.pedroconsoni.DeveloperAllocator.Developer.Model.DeveloperModel;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "tb_project")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "developer")
    @OneToMany(mappedBy = "project")
    private List<DeveloperModel> developer;

    public ProjectModel() {
    }

    public ProjectModel(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
