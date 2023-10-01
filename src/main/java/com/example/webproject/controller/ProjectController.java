package com.example.webproject.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.webproject.entity.Project;
import com.example.webproject.repository.ProjectRepository;
import com.example.webproject.service.UserActionsService;

import java.util.Optional;

@Slf4j
@Controller
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserActionsService userActionsService;

    public ProjectController() {
    }


    @GetMapping("/list")
    public ModelAndView getAllProject() {
        log.info("/list->connection");
        ModelAndView mav = new ModelAndView("list-project");
        mav.addObject("projects", projectRepository.findAll());
        userActionsService.savelog("User get all project");
        return mav;
    }


    @GetMapping("/addProjectForm")
    public ModelAndView addProjectForm() {
        ModelAndView mav = new ModelAndView("add-project-form");
        Project project = new Project();
        mav.addObject("projects", project);
        userActionsService.savelog("User adds project");
        return mav;
    }

    @PostMapping("/saveProjectForm")
    public String saveProject(@ModelAttribute Project project) {
        projectRepository.save(project);
        userActionsService.savelog("User saves project");
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long projectId) {
        ModelAndView mav = new ModelAndView("add-project-form");
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        Project project = new Project();
        if (optionalProject.isPresent()) {
            project = optionalProject.get();
        }
        mav.addObject("project", project);
        userActionsService.savelog("User see list of project");
        return mav;
    }

    @GetMapping("/deleteProject")
    public String deleteProject(@RequestParam Long projectId) {
        projectRepository.deleteById(projectId);
        userActionsService.savelog("User delete project");
        return "redirect:/list";

    }
}
