package com.thebmakes.projectms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ProjectMsApplication {

    @Autowired
    private Environment environment;

    @GetMapping("/health")
    public HashMap<String,String> health() {
        return new HashMap<String,String>() {{
            put("message", "Project-ms is up and running on port: " + environment.getProperty("local.server.port") +" ☕🍵");
        }};
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectMsApplication.class, args);
    }

}

