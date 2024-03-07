package org.com.job.client;

import java.util.List;

import org.com.job.external.company.ReviewClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "REVIEW-SERVICE-APPLICATION")
public interface ReviewClient {
	
	@GetMapping("/reviews")
	List<ReviewClass> getReviews(@RequestParam("companyId") String companyId);

}
