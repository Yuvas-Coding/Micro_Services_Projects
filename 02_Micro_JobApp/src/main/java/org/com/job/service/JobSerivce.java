package org.com.job.service;

import java.util.List;

import org.com.job.dto.JobDto;
import org.com.job.entity.JobClass;

public interface JobSerivce {
	
	List<JobDto> findAll();
	
	void createJobs(JobClass job);

	JobDto getById(Long id);

	boolean deleteById(Long id);

	boolean updateJobbyId(Long id, JobClass updateJob);

}
