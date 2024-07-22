package com.embarkx.jobms.external;

public class External_Company {
	
	private Long id;
	private String companyname;
	private String description;
	
	

	public External_Company() {
		super();
	}

	public External_Company(Long id, String companyname, String description) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
