package com.embarkx.jobms;
import java.util.List;


import com.embarkx.jobms.DTO.JobWithCompany;

public interface JobService {
	
	List<JobWithCompany> findAll();
	
	void createJob(job job);
	
	job getJobById(long id);
	
	int deleteJobById(long id);
	
	int UpdateJobById(long id, job updateJob);
	
	JobWithCompany convertToDto(job job);
}
