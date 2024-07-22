package com.embarkx.jobms;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.embarkx.jobms.DTO.JobWithCompany;
import com.embarkx.jobms.external.External_Company;

@Service
public class JobServiceImpl implements JobService{
	//List<job> jobs = new ArrayList<>();
	jobRepo jr;
	
	public JobServiceImpl(jobRepo jr) {
		this.jr = jr;
	}

	public JobWithCompany convertToDto(job job) {
		JobWithCompany jobWithCompanyDTO = new JobWithCompany();
		jobWithCompanyDTO.setJob(job);
		RestTemplate restTemplate = new RestTemplate();
		External_Company comp = restTemplate.getForObject("http://localhost:8081/companies/1", External_Company.class);
		jobWithCompanyDTO.setCompany(comp);
		return jobWithCompanyDTO;

	}
	
	@Override
	public List<JobWithCompany> findAll() {
		List<job> jobs = jr.findAll();
		List<JobWithCompany> jobWithCompanyDTOs = new ArrayList<>();
		
		return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
			
	}

	@Override
	public void createJob(job job) {
		jr.save(job);
	}

	@Override
	public job getJobById(long id) {
		/*
		 * for(job job : jobs) { if(job.getId() == id) { return job; } }
		 * 
		 * return null;
		 */
		return jr.findById(id).orElse(null);
	}

	@Override
	public int deleteJobById(long id) {	
		try {
			/*
				 * int a = 0; for(job job:jobs) { if(job.getId() == id) { jobs.remove(job); a =
				 * 1; break; } } return a;
				 */
			jr.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int UpdateJobById(long id, job updateJob) {
		Optional<job> jobOptional = jr.findById(id);
				if(jobOptional.isPresent())
				{
					job job = jobOptional.get();
					job.setTitle(updateJob.getTitle());
					job.setDescription(updateJob.getDescription());
					job.setMinSalary(updateJob.getMinSalary());
					job.setMaxSalary(updateJob.getMaxSalary());
					job.setLocation(updateJob.getLocation());
					jr.save(job);
				}
		return 1;
		
	}
}
