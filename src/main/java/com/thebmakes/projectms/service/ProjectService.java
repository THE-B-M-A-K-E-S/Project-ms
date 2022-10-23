package com.thebmakes.projectms.service;

import com.thebmakes.projectms.entity.Project;
import com.thebmakes.projectms.feign.Notification;
import com.thebmakes.projectms.feign.NotificationConsumer;
import com.thebmakes.projectms.feign.TaskConsumer;
import com.thebmakes.projectms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskConsumer taskConsumer;
    @Autowired
    private NotificationConsumer notificationConsumer;

    public List<Project> findAll() {
        List<Project> projects = projectRepository.findAll();
        projects.forEach(project -> {
            project.setTasks(taskConsumer.findAllByProjectId(project.getId()));
        });
        return projects;
    }

    public Project findById(String id) {

        Project project = projectRepository.findById(id).get();
        project.setTasks(taskConsumer.findAllByProjectId(id));
        return project;
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
            Notification notification = new Notification();
            notification.setTitle("Removed from project");
            notification.setBody("You have been removed from " + project.getName());
            notification.setUser(userId);
            notificationConsumer.add(notification);

            project.getUsers().remove(userId);
            projectRepository.save(project);
            return true;
        }
        return false;
    }

    public Project addUserFromProject(String userId, String projectId) {
        Project project = findById(projectId);
        if (!project.getUsers().contains(userId)) {
            Notification notification = new Notification();
            notification.setTitle("Added to project");
            notification.setBody("You have been added to " + project.getName());
            notification.setUser(userId);
            notificationConsumer.add(notification);

            project.getUsers().add(userId);
            projectRepository.save(project);
        }
        return project;
    }
}
