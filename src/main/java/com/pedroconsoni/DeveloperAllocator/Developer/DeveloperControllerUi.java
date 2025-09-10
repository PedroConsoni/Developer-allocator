package com.pedroconsoni.DeveloperAllocator.Developer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/developer/ui")
public class DeveloperControllerUi {

    private final DeveloperService developerService;

    public DeveloperControllerUi(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/list")
    public String listDeveloper(Model model) {
        List<DeveloperDTO> developer = developerService.listDeveloper();
        model.addAttribute("developer", developer);
        return "ListDeveloper";
    }

}
