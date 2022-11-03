package com.austral.sigback.service;

import com.austral.sigback.model.Application;
import com.austral.sigback.repository.ApplicationRepository;
import com.austral.sigback.utils.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application saveApplication(Application application) {
        return this.applicationRepository.save(application);
    }

    public List<Application> getApplicationsForJob(Long jobId) {
        return null;
    }

    public Application updateApplicationStatus(ApplicationStatus status, Long id) {
        Optional<Application> applicationOptional = this.applicationRepository.findById(id);
        applicationOptional.ifPresent(application -> application.setStatus(status));
        return this.applicationRepository.save(applicationOptional.get());
    }

    public List<Application> getFirstInterviewApplications() {
        return this.applicationRepository.findAll().stream().filter(a -> a.getStatus().equals(ApplicationStatus.FIRST_INTERVIEW)).collect(Collectors.toList());
    }

    public List<Application> getSecondInterviewApplications() {
        return this.applicationRepository.findAll().stream().filter(a -> a.getStatus().equals(ApplicationStatus.SECOND_INTERVIEW)).collect(Collectors.toList());
    }

    public List<Application> getToReiewInterviewApplications() {
        return this.applicationRepository.findAll().stream().filter(a -> a.getStatus().equals(ApplicationStatus.TO_REVIEW)).collect(Collectors.toList());
    }


}
