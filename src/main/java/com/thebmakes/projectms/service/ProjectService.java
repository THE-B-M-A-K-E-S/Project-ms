package com.thebmakes.projectms.service;

import com.thebmakes.projectms.entity.Project;
import com.thebmakes.projectms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(String id) {
        return projectRepository.findById(id).get();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void delete(String id) {
        projectRepository.deleteById(id);
    }

    public List<Project> findByUsersContains(String userId) {
        return projectRepository.findByUsersContains(userId);
    }

    public boolean isUserInProject(String userId, String projectId) {
        Project project = findById(projectId);
        return project.getUsers().contains(userId);
    }

    public boolean removeUserFromProject(String userId, String projectId) {
        Project project = findById(projectId);
        if (project.getUsers().contains(userId)) {
            project.getUsers().remove(userId);
            projectRepository.save(project);
            return true;
        }
        return false;
    }
}
