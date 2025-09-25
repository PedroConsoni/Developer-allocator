package com.pedroconsoni.DeveloperAllocator.Project;

import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperDTO;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pedroconsoni.DeveloperAllocator.Developer.DeveloperModel;
import java.util.Arrays;


import java.util.List;

@Controller
@RequestMapping(("project/ui"))
public class ProjectControllerUi {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final DeveloperRepository developerRepository;

    public ProjectControllerUi(ProjectService projectService, ProjectRepository projectRepository, ProjectMapper projectMapper, DeveloperRepository developerRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.developerRepository = developerRepository;
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("developers", developerRepository.findAll());
        return "CreateProject";
    }

    @PostMapping("/save")
    public String saveProject(
            @ModelAttribute ProjectDTO projectDTO,
            @RequestParam("developerIds") String developerIds) {

        ProjectModel project = new ProjectModel();
        project.setName(projectDTO.getName());
        project.setDifficulty(projectDTO.getDifficulty());
        project.setType(projectDTO.getType());

        List<Long> ids = Arrays.stream(developerIds.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .toList();

        List<DeveloperModel> devs = developerRepository.findAllById(ids);
        projectDTO.setDeveloper(devs);
        for (DeveloperModel dev : devs) {
            dev.setProject(project);
        }
        project.setDeveloper(devs);
        projectRepository.save(project);
        return "redirect:/project/ui/list";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        ProjectModel projectModel = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID " + id));

        ProjectDTO projectDTO = projectMapper.map(projectModel);
        model.addAttribute("project", projectDTO);
        model.addAttribute("developers", developerRepository.findAll());
        return "UpdateProject";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdateProject(@ModelAttribute ProjectDTO projectDTO,
                                    @RequestParam(required = false) String developerIds) {

        ProjectModel projectModel = projectRepository.findById(projectDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID " + projectDTO.getId()));

        projectModel.setName(projectDTO.getName());
        projectModel.setDifficulty(projectDTO.getDifficulty());
        projectModel.setType(projectDTO.getType());

        if (developerIds != null && !developerIds.isBlank()) {
            List<Long> ids = Arrays.stream(developerIds.split(","))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .toList();

            for (Long devId : ids) {
                DeveloperModel dev = developerRepository.findById(devId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid developer ID: " + devId));
                if (dev.getProject() == null || dev.getProject().getId() != projectModel.getId()) {
                    dev.setProject(projectModel);
                    developerRepository.save(dev);
                }
            }
        }
        projectRepository.save(projectModel);
        return "redirect:/project/ui/list";
    }


    @GetMapping("/list")
    public String listProject(Model model) {
        List<ProjectDTO> projects = projectService.listProject();
        model.addAttribute("projects", projects);
        return "ListProject";
    }

    @GetMapping("/list/{id}")
    public String listProjectsByID(@PathVariable Long id, Model model) {
        ProjectDTO project = projectService.listProjectByID(id);
        if (project != null) {
            model.addAttribute("project", project);
            return "ShowProjectDetails";
        } else {
            model.addAttribute("Message", "Project not found");
            return "ListProject";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteProjectByID(@PathVariable Long id) {
        projectService.deleteProjectByID(id);
        return "redirect:/project/ui/list";
    }
}
