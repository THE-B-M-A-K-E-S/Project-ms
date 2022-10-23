package com.thebmakes.projectms.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String id;
    private String title;
    private String body;
    private boolean isViewed;
    private String user;
}
