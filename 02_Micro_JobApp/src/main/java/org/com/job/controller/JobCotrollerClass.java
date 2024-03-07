package org.com.job.controller;

import java.util.List;

import org.com.job.dto.JobDto;
import org.com.job.entity.JobClass;
import org.com.job.service.JobSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/jobs")
public class JobCotrollerClass {

	@Autowired
	private JobSerivce jobSerivce;

	@GetMapping("/jobs")
	public ResponseEntity<List<JobDto>> getAllJobs() {
		return ResponseEntity.ok(jobSerivce.findAll());
	}

	@PostMapping("/createJobs")
	public ResponseEntity<String> createJobs(@RequestBody JobClass jobClass) {

		jobSerivce.createJobs(jobClass);
		return new ResponseEntity<String>("job added succesfully", HttpStatus.CREATED);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<JobDto> getById(@PathVariable("id") Long id) {
		 JobDto jobById = jobSerivce.getById(id);
		if (jobById != null)
			return new ResponseEntity<JobDto>(jobById, HttpStatus.OK);
		return new ResponseEntity<JobDto>(HttpStatusCode.valueOf(400));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		boolean delete = jobSerivce.deleteById(id);
		if (delete)
			return new ResponseEntity<String>("delete succesfully", HttpStatus.OK);
		return new ResponseEntity<String>(HttpStatusCode.valueOf(400));
	}

	// @PutMapping("/updated/{id}")
	@RequestMapping(value = "/updated/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody JobClass updateJob) {
		boolean updated = jobSerivce.updateJobbyId(id, updateJob);
		if (updated)
			return new ResponseEntity<String>("job is updated", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatusCode.valueOf(400));

	}
}
