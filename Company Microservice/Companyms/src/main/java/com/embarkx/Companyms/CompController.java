package com.embarkx.Companyms;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompController {

	CompService sr;
	
	public CompController(CompService sr) {
		super();
		this.sr = sr;
	}
	@PostMapping
	public ResponseEntity<String> addeCompany(@RequestBody Company comp) {
		sr.addCompany(comp);
		return new ResponseEntity<String>("Created Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		List<Company> list = sr.getAllCompanies();
		if(list.isEmpty())
		{
			return new ResponseEntity<List<Company>>(list,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Company>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable long id, @RequestBody Company comp)
	{
		boolean check;
		check = sr.updateCompany(id, comp);
		if(check == true)
		{
			return new ResponseEntity<>(id+" Updated Successfully",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<>("No record found with id "+id,HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable long id) {
		boolean check;
		check = sr.deleteCompany(id);
		if(check == true)
		{
			return new ResponseEntity<>(id+" Deleted Successfully",HttpStatus.OK);
		}
		else {
				return new ResponseEntity<>("No record found with id "+ id,HttpStatus.NO_CONTENT);
			}
		}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable long id)
	{
		if(sr.getCompanyById(id) != null)
		{
			Company comp = sr.getCompanyById(id);
			return new ResponseEntity<>(comp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
