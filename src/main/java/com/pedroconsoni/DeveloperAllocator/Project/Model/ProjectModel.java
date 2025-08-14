package com.pedroconsoni.DeveloperAllocator.Project.Model;

import com.pedroconsoni.DeveloperAllocator.Developer.Model.DeveloperModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "tb_project")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "project")
    private List<DeveloperModel> developer;

}
