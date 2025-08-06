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
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // Vários desenvolvedores para um único projeto
    @ManyToOne
    @JoinColumn(name = "project_id") // Foreing Key ou chave estrangeira
    private ProjectModel projectModel;

}
