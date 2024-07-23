package com.embarkx.Reviewms;

import com.embarkx.Reviewms.external.External_Company;

public class ReviewWithCompany {

	private long id;
	private String title;
	private String description;
	private double rating;
	External_Company comp;
	
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public External_Company getComp() {
		return comp;
	}
	public void setComp(External_Company comp) {
		this.comp = comp;
	}
	
	
}
