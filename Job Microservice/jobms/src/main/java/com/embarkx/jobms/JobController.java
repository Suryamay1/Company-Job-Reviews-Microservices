package com.embarkx.jobms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	List<job> jobs = new ArrayList<>();
	
	@GetMapping("/jobs")
	public ResponseEntity<List<job>> findAll(){
		return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<job> getJobById(@PathVariable long id) {
		job job = jobService.getJobById(id);
		if(job != null){
			return new ResponseEntity<>(job,HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> DeleteByid(@PathVariable long id) {
		int res;
		res = jobService.deleteJobById(id);
		if(res == 1) {
		return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("Record Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> UpdateByid(@PathVariable long id, @RequestBody job updateJob) {
		int res;
		res = jobService.UpdateJobById(id,updateJob);
		if(res == 1) {
		return new ResponseEntity<>("Record Updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("Record Not Found",HttpStatus.NOT_FOUND);
	}
		
}
