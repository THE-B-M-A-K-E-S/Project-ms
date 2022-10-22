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

    @GetMapping("/users/{userId}")
    public List<Project> getUserProjects(@PathVariable String userId) {
        return projectService.findByUsersContains(userId);
    }

    @GetMapping("/users/{userId}/projects/{projectId}")
    public boolean isUserInProject(@PathVariable String userId, @PathVariable String projectId) {
        return projectService.isUserInProject(userId, projectId);
    }

    @DeleteMapping("/users/{userId}/projects/{projectId}")
    public boolean removeUserFromProject(@PathVariable String userId, @PathVariable String projectId) {
        return projectService.removeUserFromProject(userId, projectId);
    }


}
