package com.pedroconsoni.DeveloperAllocator.Developer.Model;

import com.pedroconsoni.DeveloperAllocator.Project.Model.ProjectModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_developer")
public class DeveloperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "project")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    public DeveloperModel() {
    }

    public DeveloperModel(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
