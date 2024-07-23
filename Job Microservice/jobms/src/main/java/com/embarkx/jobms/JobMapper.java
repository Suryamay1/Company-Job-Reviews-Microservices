package com.embarkx.jobms;

import java.util.List;

import com.embarkx.jobms.DTO.JobDTO;
import com.embarkx.jobms.external.External_Company;
import com.embarkx.jobms.external.External_Review;

public class JobMapper {

	
	public static JobDTO mapToJobDTO(job job,External_Company comp,List<External_Review> reviews) {
		
		JobDTO JobDTO = new JobDTO(); 
		JobDTO.setId(job.getId());
		JobDTO.setTitle(job.getTitle());
		JobDTO.setDescription(job.getDescription());
		JobDTO.setMinSalary(job.getMinSalary());
		JobDTO.setMaxSalary(job.getMaxSalary());
		JobDTO.setLocation(job.getLocation());
		JobDTO.setCompany(comp);
		JobDTO.setReviews(reviews);
		return JobDTO;
		
	}
}
