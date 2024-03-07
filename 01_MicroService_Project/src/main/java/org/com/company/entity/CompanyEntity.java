package org.com.company.entity;

import java.util.List;

import org.com.job.entity.JobClass;
import org.com.review.entity.ReviewClass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Company_Table")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String companyName;
	
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "companyEntity")
	private List<JobClass> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<ReviewClass> reviews;

}
