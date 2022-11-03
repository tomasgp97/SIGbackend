package com.austral.sigback.controller;

import com.austral.sigback.model.Job;
import com.austral.sigback.model.User;
import com.austral.sigback.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobs")
public class JobController {


    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job saved = this.jobService.createPost(job);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = this.jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/reqs")
    public ResponseEntity<List<Job>> getAllRequirements() {
        List<Job> reqs = this.jobService.getRequirements();
        return new ResponseEntity<>(reqs, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        Job updated = this.jobService.updateJob(job);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }





}
