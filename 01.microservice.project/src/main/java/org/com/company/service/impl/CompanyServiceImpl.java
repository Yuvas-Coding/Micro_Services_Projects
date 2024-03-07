package org.com.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.com.company.entity.CompanyEntity;
import org.com.company.repository.CompanyRepository;
import org.com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<CompanyEntity> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public boolean updateCompany(Long id, CompanyEntity company) {
		// TODO Auto-generated method stub
		Optional<CompanyEntity> optionalCompany = companyRepository.findById(id);
		
		if(optionalCompany.isPresent()) {
			CompanyEntity companyToUpdate = optionalCompany.get();
			
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setCompanyName(company.getCompanyName());
			companyToUpdate.setJobs(company.getJobs());
			
			companyRepository.save(companyToUpdate);
			
			return true;
		}
		else {
			return false;	
		}
	}

	@Override
	public void createCompany(CompanyEntity company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
		
	}

	@Override
	public boolean deleteCompany(Long id) {
		// TODO Auto-generated method stub
		
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public CompanyEntity getById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
	}






	
	
	
}
