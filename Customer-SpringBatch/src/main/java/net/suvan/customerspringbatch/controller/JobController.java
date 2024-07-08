package net.suvan.customerspringbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @GetMapping
    public Map<String, String> welcomeMessage(){
        Map<String, String> response = new HashMap<>();
        response.put("message","Endpoint Service Working");
        return response;
    }

    @PostMapping("/importCustomers")
    public Map<String, String> importCsvToDBJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
            Map<String, String> msg = new HashMap<>();
            msg.put("Message","Records Inserted Successfully");
            return msg;
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
//            e.printStackTrace();
            Map<String, String> error = new HashMap<>();
            error.put("Error",e.getMessage());
            return error;
        }
    }
}
