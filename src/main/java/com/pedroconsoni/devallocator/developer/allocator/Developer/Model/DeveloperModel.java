package com.pedroconsoni.devallocator.developer.allocator.Developer.Model;

import com.pedroconsoni.devallocator.developer.allocator.Project.Model.ProjectModel;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "tb_developer")
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

    public DeveloperModel() {
    }

    public DeveloperModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
