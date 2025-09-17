package com.pedroconsoni.DeveloperAllocator.Developer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/developer/ui")
public class DeveloperControllerUi {

    private final DeveloperService developerService;
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    public DeveloperControllerUi(DeveloperService developerService, DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerService = developerService;
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    @GetMapping("/create")
    public String createDeveloper(Model model) {
        model.addAttribute("developer", new DeveloperDTO());
        return "CreateDeveloper";
    }

    @PostMapping("/save")
    public String saveDeveloper(@ModelAttribute DeveloperDTO developerDTO) {
        DeveloperDTO developer = developerService.createDeveloper(developerDTO);
        return "redirect:/developer/ui/list";
    }


    @GetMapping("/list")
    public String listDeveloper(Model model) {
        List<DeveloperDTO> developer = developerService.listDeveloper();
        model.addAttribute("developer", developer);
        return "ListDeveloper";
    }


    @GetMapping("/list/{id}")
    public String listDeveloperByID(@PathVariable Long id, Model model) {
        DeveloperDTO developer = developerService.listDeveloperByID(id);
        if (developer != null) {
            model.addAttribute("developer", developer);
            return "ShowDeveloperDetails";
        } else {
            model.addAttribute("Message", "Developer not found");
            return "ListDeveloper";
        }
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        DeveloperModel developerModel = developerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        DeveloperDTO developerDTO = developerMapper.map(developerModel);
        model.addAttribute("developer", developerDTO);
        return "UpdateDeveloper";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdateDeveloper(@ModelAttribute("developer") DeveloperDTO developerDTO) {
        DeveloperModel developerModel = developerRepository.findById(developerDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + developerDTO.getId()));

        developerMapper.updateDeveloperFromDto(developerDTO, developerModel);
        developerRepository.save(developerModel);
        return "redirect:/developer/ui/list";
    }



    @GetMapping("/delete/{id}")
    public String deleteDeveloperByID(@PathVariable Long id) {
      developerService.deleteDeveloperByID(id);
      return "redirect:/developer/ui/list";
    }

}
