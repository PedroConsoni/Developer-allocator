package com.pedroconsoni.DeveloperAllocator.Project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(("project/ui"))
public class ProjectControllerUi {

    private final ProjectService projectService;

    public ProjectControllerUi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public String listProject(Model model) {
        List<ProjectDTO> projects = projectService.listProject();
        model.addAttribute("project", projects);
        return "ListProject";
    }
}
