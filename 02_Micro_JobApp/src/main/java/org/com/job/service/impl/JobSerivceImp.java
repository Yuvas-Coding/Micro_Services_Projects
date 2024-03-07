package org.com.job.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.com.job.Mapper.JobMapper;
import org.com.job.client.CompanyClient;
import org.com.job.client.ReviewClient;
import org.com.job.dto.JobDto;
import org.com.job.entity.JobClass;
import org.com.job.external.company.Company;
import org.com.job.external.company.ReviewClass;
import org.com.job.repository.JobRepository;
import org.com.job.service.JobSerivce;
import org.hibernate.internal.util.collections.JoinedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class JobSerivceImp implements JobSerivce {

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CompanyClient companyClient;
	
	@Autowired
	ReviewClient reviewClient;

	// private List<JobClass> jobs = new ArrayList<JobClass>();



	@Override
	@CircuitBreaker(name = "companyBreaker",fallbackMethod = "companyBreakerFallBack")
	public List<JobDto> findAll() {
		// TODO Auto-generated method stub
		
		List<JobClass> jobs=jobRepository.findAll();
		List<JobDto> jobDtos=new ArrayList<>();
		
		return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	public List<String> companyBreakerFallBack(Exception e){
		List<String> list= new ArrayList<>();
		list.add("Dummay");
		return list ;
	}

	@Override
	public void createJobs(JobClass job) {
		// TODO Auto-generated method stub
	
		jobRepository.save(job);
	}

	@Override
	public JobDto getById(Long id) {
		 JobClass job = jobRepository.findById(id).orElse(null);
		 return convertToDto(job);
		
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
			job.setCompanyId(updateJob.getCompanyId());
			jobRepository.save(job);
			return true;
		}

		return false;
	}
	
	
	private JobDto convertToDto(JobClass job) {
		
			
			//RestTemplate restTemplate = new RestTemplate();
			
			//Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8082/getCompany/"+job.getCompanyId()  ,Company.class);
			
			/*
			 * ResponseEntity<List<ReviewClass>> reviewResponse =
			 * restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?companyId="+job.
			 * getCompanyId(), HttpMethod.GET ,null,new
			 * ParameterizedTypeReference<List<ReviewClass>>() { });
			 */
		
			
			
			Company company = companyClient.getCompany(job.getCompanyId());
			
			List<ReviewClass> reviews = reviewClient.getReviews(job.getCompanyId());
			
			
			
			//List<ReviewClass> reviews1 = reviewResponse.getBody();
			
			JobDto mapToJobWithCompanyDto = JobMapper.mapToJobWithCompanyDto(job,company,reviews);
			
			//mapToJobWithCompanyDto.setCompany(company);
			
			return mapToJobWithCompanyDto;
	}
}