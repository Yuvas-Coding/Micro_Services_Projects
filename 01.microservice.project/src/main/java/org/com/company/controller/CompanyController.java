package org.com.company.controller;

import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.com.company.entity.CompanyEntity;
import org.com.company.service.CompanyService;
import org.com.review.entity.ReviewClass;
import org.com.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//it is controller class 

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/getCompanies")
	public ResponseEntity<List<CompanyEntity>> getAllCompany() {

		List<CompanyEntity> allCompany = companyService.getAllCompanies();
		return new ResponseEntity<List<CompanyEntity>>(allCompany, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyEntity companyEntity) {
		companyService.updateCompany(id, companyEntity);
		return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
	}

	@PostMapping("/createCompany")
	public ResponseEntity<String> companyCreated(@RequestBody CompanyEntity companyEntity) {
		companyService.createCompany(companyEntity);
		return new ResponseEntity<String>("company created", HttpStatus.CREATED);

	}

	@DeleteMapping("deleteCompany/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
		boolean deleteCompany = companyService.deleteCompany(id);
		if (deleteCompany) {
			return new ResponseEntity<String>("deleted sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("company not found", HttpStatus.OK);
		}
	}

	@GetMapping("/getCompany/{id}")
	public ResponseEntity<CompanyEntity> getById(@PathVariable("id") Long id) {

		CompanyEntity getByIdCompany = companyService.getById(id);
		if (getByIdCompany != null) {
			return new ResponseEntity<CompanyEntity>(getByIdCompany, HttpStatus.OK);
		} else {
			return new ResponseEntity<CompanyEntity>(HttpStatus.NOT_FOUND);
		}

	}


}
