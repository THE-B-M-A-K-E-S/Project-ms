package com.thebmakes.projectms.repository;

import com.thebmakes.projectms.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

    // get Projects where users contain userId
    List<Project> findByUsersContains(String userId);
}
