package org.com.job.client;

import org.com.job.external.company.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="COMPANY-SERVICE")
public interface CompanyClient {
	
	@GetMapping("/company/getCompany/{id}")
	 Company getCompany(@PathVariable("id") String string);

}
