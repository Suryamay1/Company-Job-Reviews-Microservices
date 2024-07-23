package com.embarkx.jobms;
import java.util.List;


import com.embarkx.jobms.DTO.JobDTO;

public interface JobService {
	
	List<JobDTO> findAll();
	
	void createJob(job job);
	
	//job getJobById(long id);
	
	int deleteJobById(long id);
	
	int UpdateJobById(long id, job updateJob);
	
	JobDTO convertToDto(job job);

	JobDTO getJobById(Long id);
}
