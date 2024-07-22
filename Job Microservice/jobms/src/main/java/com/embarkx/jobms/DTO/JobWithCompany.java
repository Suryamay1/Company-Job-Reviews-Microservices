package com.embarkx.jobms.DTO;


import com.embarkx.jobms.external.External_Company;
import com.embarkx.jobms.job;

public class JobWithCompany {

	
	private job job;
	private External_Company company;
	public job getJob() {
		return job;
	}
	public void setJob(job job) {
		this.job = job;
	}
	public External_Company getCompany() {
		return company;
	}
	public void setCompany(External_Company company) {
		this.company = company;
	}
	
	
}
