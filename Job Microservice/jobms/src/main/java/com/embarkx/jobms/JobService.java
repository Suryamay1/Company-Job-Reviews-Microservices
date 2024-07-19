package com.embarkx.jobms;
import java.util.List;

public interface JobService {
	
	List<job> findAll();
	
	void createJob(job job);
	
	job getJobById(long id);
	
	int deleteJobById(long id);
	
	int UpdateJobById(long id, job updateJob);
}
