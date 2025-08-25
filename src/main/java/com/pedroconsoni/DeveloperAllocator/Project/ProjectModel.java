package com.pedroconsoni.DeveloperAllocator.Project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
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

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<DeveloperModel> developer;

}
