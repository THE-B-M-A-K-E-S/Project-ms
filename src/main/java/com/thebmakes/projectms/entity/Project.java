package com.thebmakes.projectms.entity;


import com.thebmakes.projectms.feign.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> users = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
}
