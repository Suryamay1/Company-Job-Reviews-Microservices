package com.embarkx.Companyms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class CompanyImpl implements CompService{

	CompRepo cr;
	
	public CompanyImpl(CompRepo cr) {
		super();
		this.cr = cr;
	}

	@Override
	public List<Company> getAllCompanies() {
		List <Company> list = new ArrayList<Company>();
		list = cr.findAll();
		return list;
	}

	@Override
	public void addCompany(Company comp) {
		cr.save(comp);
	}

	@Override
	public boolean updateCompany(long id, Company comp) {
		boolean check;
		check = cr.existsById(id);
		if(check == true)
		{
		Optional<Company> op = cr.findById(id);
		Company co = op.get();
		if (co != null)
			{
				co.setCompanyname(comp.getCompanyname());
				co.setDescription(comp.getDescription());
				cr.save(co);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean deleteCompany(long id) {
		if(cr.existsById(id))
		{
			cr.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(long id) {
		if(cr.existsById(id))
		{
			Optional<Company> op = cr.findById(id);
			Company comp = op.get();
			return comp;
		}
		return null;
	}
}