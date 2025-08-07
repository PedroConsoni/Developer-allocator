package com.pedroconsoni.devallocator.developer.allocator.Developer.Model;

import com.pedroconsoni.devallocator.developer.allocator.Project.Model.ProjectModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_developer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    // Vários desenvolvedores para um único projeto
    @ManyToOne
    @JoinColumn(name = "project_id") // Foreing Key ou chave estrangeira
    private ProjectModel projectModel;

}
