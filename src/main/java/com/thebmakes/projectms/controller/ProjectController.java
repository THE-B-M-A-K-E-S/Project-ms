package com.thebmakes.projectms.controller;

import com.thebmakes.projectms.entity.Project;
import com.thebmakes.projectms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public Project findById(@PathVariable String id) {
        return projectService.findById(id);
    }

    @PostMapping("")
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping("")
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        projectService.delete(id);
    }


}
