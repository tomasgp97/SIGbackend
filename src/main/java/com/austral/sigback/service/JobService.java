package com.austral.sigback.service;

import com.austral.sigback.model.Job;
import com.austral.sigback.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createPost(Job job) {
        return this.jobRepository.save(job); //tojobdto
    }

    public List<Job> getAllJobs() {
        return this.jobRepository.findAll().stream().filter(j -> j.getDescription() != null).collect(Collectors.toList());
    }

    public List<Job> getRequirements() {
        return this.jobRepository.findAll().stream().filter(j -> j.getDescription() == null).collect(Collectors.toList());
    }


    public Job updateJob(Job job) {
        Optional<Job> toUpdate = this.jobRepository.findById(job.getId());

        if (toUpdate.isEmpty()) {
            throw new RuntimeException("Job of id: " + job.getId() + " not found.");
        }

        Job toSave = toUpdate.get();
        toSave.setDescription(job.getDescription());

        return this.jobRepository.save(toSave);
    }
}
