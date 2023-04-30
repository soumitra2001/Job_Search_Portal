package com.geekster.JobPortal.controller;


import com.geekster.JobPortal.model.Job;
import com.geekster.JobPortal.model.JobType;
import com.geekster.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAll();
    }

    @PostMapping
    public String saveJobs(@Valid @RequestBody List<Job> jobs) {
        return jobService.saveJobs(jobs);
    }

    @PutMapping
    public String updateIfExist(@Valid @RequestBody Job job) {
        return jobService.updateIfExist(job);
    }

    @DeleteMapping("/{id}")
    public String deleteJobById(@PathVariable int id) {
        return jobService.deleteJobById(id);
    }

    @GetMapping("/jobType/{jobType}")
    public List<Job> getAllJobsByJobType(@PathVariable String jobType) {
        JobType jobTypeEnum = JobType.valueOf(jobType);
        return jobService.getAllJobsByJobType(jobTypeEnum);
    }

    @GetMapping("/title/{title}")
    public List<Job> getAllJobsByTitle(@PathVariable String title) {
        return jobService.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/latest")
    public List<Job> getLatestJobs() {
        return jobService.findTop10ByOrderByAppliedDateDesc();
    }

    @GetMapping("/companyName/{companyName}")
    public List<Job> getAllJobsByCompanyName(@PathVariable String companyName) {
        return jobService.findByCompanyNameContainingIgnoreCase(companyName);
    }


    //Custom Queries

    @PutMapping("/update/{id}/jobType/{jobType}")
    public void updateJobTypeById(@PathVariable int id, @PathVariable JobType jobType ) {
        jobService.updateJobTypeById(id,jobType);
    }

    @PutMapping("/update/id/{id}/salary/{salary}")
    public void updateSalary(@PathVariable int id,@PathVariable Double salary){
        jobService.updateSalary(id,salary);
    }

    @PutMapping("id/{id}/companyName/{companyName}")
    public void updateCompanyNameById(@PathVariable int id,@PathVariable String companyName){
        jobService.updateCompanyNameById(id,companyName);
    }

    @DeleteMapping("/salary/{salary}")
    public void removeJobsLessThanSalary(@PathVariable Double salary){
        jobService.removeJobsLessThanSalary(salary);
    }

}
