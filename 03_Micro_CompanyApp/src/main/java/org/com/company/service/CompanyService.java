package org.com.company.service;

import java.util.List;

import org.com.company.entity.CompanyEntity;


public interface CompanyService {

	
	public List<CompanyEntity> getAllCompanies();
	
	public boolean updateCompany(Long id, CompanyEntity company);
	
	public void createCompany(CompanyEntity company);
	
	public boolean deleteCompany(Long id);
	
	public CompanyEntity getById(Long id);
}
