package com.thebmakes.projectms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "notifs-ms", path = "/notifications")
public interface NotificationConsumer {

    @PostMapping("")
    public Notification add(@RequestBody Notification notification);
}
