package com.embarkx.Companyms;

import java.util.List;

public interface CompService {

	List<Company> getAllCompanies();
	
	void addCompany(Company comp);
	
	boolean updateCompany(long id,Company comp);
	
	boolean deleteCompany(long id);
	
	Company getCompanyById(long id);
}
