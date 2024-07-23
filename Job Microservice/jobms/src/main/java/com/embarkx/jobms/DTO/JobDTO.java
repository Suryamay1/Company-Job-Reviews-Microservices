package com.embarkx.jobms.DTO;


import java.util.List;

import com.embarkx.jobms.external.External_Company;
import com.embarkx.jobms.external.External_Review;


public class JobDTO {

	private long id;
	private String title;
	private String description;
	private String minSalary; 
	private String maxSalary;
	private String location;
	private External_Company company;
	private List<External_Review> reviews;
	
	
	
	public List<External_Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<External_Review> reviews) {
		this.reviews = reviews;
	}
	public JobDTO() {
		
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
