package org.com.job.Mapper;

import java.util.List;

import org.com.job.dto.JobDto;
import org.com.job.entity.JobClass;
import org.com.job.external.company.Company;
import org.com.job.external.company.ReviewClass;

public class JobMapper {
	
	public static JobDto mapToJobWithCompanyDto(JobClass jobClass,Company company, List<ReviewClass> reviews) {
		
		JobDto jobDto = new JobDto();
		
		jobDto.setId(jobClass.getId());
		jobDto.setTitle(jobClass.getTitle());
		jobDto.setDescription(jobClass.getDescription());
		jobDto.setLocation(jobClass.getLocation());
		jobDto.setMaxSalary(jobClass.getMaxSalary());
		jobDto.setMinSalary(jobClass.getMinSalary());
		jobDto.setCompany(company);
		jobDto.setReview(reviews);
		return jobDto;
		

	}

}
