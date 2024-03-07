package org.com.job.dto;

import java.util.List;

import org.com.job.entity.JobClass;
import org.com.job.external.company.Company;
import org.com.job.external.company.ReviewClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {

	private Long id;

	private String title;

	private String description;

	private String minSalary;

	private String maxSalary;

	private String location;

	private Company company;
	
	private List<ReviewClass> review;

}
