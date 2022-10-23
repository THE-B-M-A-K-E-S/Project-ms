package com.thebmakes.projectms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "task-ms", path = "/tasks")

public interface TaskConsumer {

    @GetMapping("")
    List<Task> findAll();

    @GetMapping("project/{id}")
    List<Task> findAllByProjectId(@PathVariable String id);

    @GetMapping("{id}")
    Task findById(@PathVariable String id);

    @PostMapping("")
    Task save(@RequestBody Task task);

    @PutMapping("")
    Task update(@RequestBody Task task);

    @DeleteMapping("{id}")
    void delete(@PathVariable String id);
}
