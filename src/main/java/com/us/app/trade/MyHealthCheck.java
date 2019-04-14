package com.us.app.trade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Udyan Shardhar
 * Api health check
 */
@RestController
@RequestMapping("trade/api")
public class MyHealthCheck {
    @GetMapping("/health")
    public String ping() {
        return "I am listening";
    }
}
