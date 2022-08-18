package com.austral.sigback.controller;

import com.austral.sigback.service.JobService;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class JobController {
//
//    @GetMapping
//    @PutMapping
//    @PatchMapping
//    @PostMapping
//    @RequestMapping

    private JobService jobService;

    @GetMapping("/job")
    @ResponseBody
    public String getJobByName(@RequestParam String name) {
        return jobService.getJobByName(name);
    }
}
