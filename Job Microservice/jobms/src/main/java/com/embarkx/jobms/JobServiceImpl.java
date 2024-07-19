package com.embarkx.jobms;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
	//List<job> jobs = new ArrayList<>();
	jobRepo jr;
	
	public JobServiceImpl(jobRepo jr) {
		this.jr = jr;
	}

	@Override
	public List<job> findAll() {
		return jr.findAll();
	}

	@Override
	public void createJob(job job) {
		jr.save(job);
	}

	@Override
	public job getJobById(long id) {
		/*
		 * for(job job : jobs) { if(job.getId() == id) { return job; } }
		 * 
		 * return null;
		 */
		return jr.findById(id).orElse(null);
	}

	@Override
	public int deleteJobById(long id) {	
		try {
			/*
				 * int a = 0; for(job job:jobs) { if(job.getId() == id) { jobs.remove(job); a =
				 * 1; break; } } return a;
				 */
			jr.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int UpdateJobById(long id, job updateJob) {
		Optional<job> jobOptional = jr.findById(id);
				if(jobOptional.isPresent())
				{
					job job = jobOptional.get();
					job.setTitle(updateJob.getTitle());
					job.setDescription(updateJob.getDescription());
					job.setMinSalary(updateJob.getMinSalary());
					job.setMaxSalary(updateJob.getMaxSalary());
					job.setLocation(updateJob.getLocation());
					jr.save(job);
				}
		return 1;
		
	}
}
