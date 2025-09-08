package com.pedroconsoni.DeveloperAllocator.Developer;

import com.pedroconsoni.DeveloperAllocator.Project.ProjectModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_developer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeveloperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = true)
    private ProjectModel project;

}
