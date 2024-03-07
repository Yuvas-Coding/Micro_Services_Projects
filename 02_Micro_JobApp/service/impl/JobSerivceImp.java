package org.com.job.service.impl;


import java.util.List;
import java.util.Optional;

import org.com.job.entity.JobClass;
import org.com.job.repository.JobRepository;
import org.com.job.service.JobSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSerivceImp implements JobSerivce {

	@Autowired
	JobRepository jobRepository;

	// private List<JobClass> jobs = new ArrayList<JobClass>();



	@Override
	public List<JobClass> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	public void createJobs(JobClass job) {
		// TODO Auto-generated method stub
	
		jobRepository.save(job);
	}

	@Override
	public JobClass getById(Long id) {
		return jobRepository.findById(id).orElse(null);
		// TODO Auto-generated method stub

		/*
		 * for(JobClass job:jobs) { if(job.getId().equals(id)) { return job; } } return
		 * null;
		 */
	}

	@Override
	public boolean deleteById(Long id) {

		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean updateJobbyId(Long id, JobClass updateJob) {
		// TODO Auto-generated method stub

		Optional<JobClass> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			JobClass job = jobOptional.get();
			job.setDescription(updateJob.getDescription());
			job.setTitle(updateJob.getTitle());
			job.setMaxSalary(updateJob.getMaxSalary());
			job.setMinSalary(updateJob.getMinSalary());
			job.setLocation(updateJob.getLocation());
			jobRepository.save(job);
			return true;
		}

		return false;
	}

}
