package com.austral.sigback.controller;


import com.austral.sigback.dto.ApplicationDto;
import com.austral.sigback.model.Application;
import com.austral.sigback.model.Budget;
import com.austral.sigback.service.ApplicationService;
import com.austral.sigback.utils.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application saved = this.applicationService.saveApplication(application);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getApplicationsByStatus(@RequestParam ApplicationStatus status) {
        List<Application> applications = this.applicationService.getApplicationsByStatus(status);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Application>> getApplicationsForJob(@RequestParam Long jobId) {
        List<Application> applications = this.applicationService.getApplicationsForJob(jobId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Application> updateApplicationStatus(@RequestBody ApplicationDto dto){
        Application updated = this.applicationService.updateApplicationStatus(dto.getStatus(), dto.getId());
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


}
