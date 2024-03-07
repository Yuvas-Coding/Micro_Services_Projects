package org.com.job.external.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewClass {

	private Long id;

	private String title;

	private String description;

	private double rating;

	

}
