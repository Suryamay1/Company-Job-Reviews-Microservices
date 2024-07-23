package com.embarkx.jobms;

import com.embarkx.jobms.DTO.JobWithCompany;
import com.embarkx.jobms.external.External_Company;

public class JobMapper {

	
	public static JobWithCompany mapToJobWithCompanyDto(job job,External_Company comp) {
		
		JobWithCompany JobWithCompanyDTO = new JobWithCompany();
		JobWithCompanyDTO.setId(job.getId());
		JobWithCompanyDTO.setTitle(job.getTitle());
		JobWithCompanyDTO.setDescription(job.getDescription());
		JobWithCompanyDTO.setMinSalary(job.getMinSalary());
		JobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
		JobWithCompanyDTO.setLocation(job.getLocation());
		JobWithCompanyDTO.setCompany(comp);
		return JobWithCompanyDTO;
		
	}
}
