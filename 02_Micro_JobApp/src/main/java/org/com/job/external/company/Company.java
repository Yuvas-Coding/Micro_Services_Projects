package org.com.job.external.company;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Company {


	private Long Id;

	private String companyName;

	private String description;

}
