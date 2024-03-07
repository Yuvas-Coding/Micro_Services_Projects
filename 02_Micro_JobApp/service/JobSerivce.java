package org.com.job.service;

import java.util.List;

import org.com.job.entity.JobClass;

public interface JobSerivce {
	
	List<JobClass> findAll();
	
	void createJobs(JobClass job);

	JobClass getById(Long id);

	boolean deleteById(Long id);

	boolean updateJobbyId(Long id, JobClass updateJob);

}
