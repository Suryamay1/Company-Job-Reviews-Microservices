package com.embarkx.jobms.DTO;


import com.embarkx.jobms.external.External_Company;
import com.embarkx.jobms.job;

public class JobWithCompany {

	private long id;
	private String title;
	private String description;
	private String minSalary; 
	private String maxSalary;
	private String location;
	private External_Company company;
	
	
	public JobWithCompany(long id, String title, String description, String minSalary, String maxSalary,
			String location, External_Company company) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
		this.company = company;
	}
	public JobWithCompany() {
		
	}
	public External_Company getCompany() {
		return company;
	}
	public void setCompany(External_Company company) {
		this.company = company;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
