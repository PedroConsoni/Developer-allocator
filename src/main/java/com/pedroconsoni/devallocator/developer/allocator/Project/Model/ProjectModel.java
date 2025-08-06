package com.pedroconsoni.devallocator.developer.allocator.Project.Model;

import com.pedroconsoni.devallocator.developer.allocator.Developer.Model.DeveloperModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_project")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //Um projeto pode ter vários desenvolvedores
    @OneToMany(mappedBy = "projectModel")
    private List<DeveloperModel> developerModels;

    public ProjectModel() {
    }

    public ProjectModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
