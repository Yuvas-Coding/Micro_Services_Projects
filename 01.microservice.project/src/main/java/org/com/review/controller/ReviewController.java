package org.com.review.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/reviews")
	public ResponseEntity<List<ReviewClass>> getAllreviews(@PathVariable Long companyId) {
		return new ResponseEntity<List<ReviewClass>>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody ReviewClass review) {
		boolean reviewSaved = reviewService.addReview(companyId, review);

		if (reviewSaved)
			return new ResponseEntity<String>("review added successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("review not saved successfully", HttpStatus.NOT_FOUND);

	}

	@GetMapping("reviews/{reviewId}")
	public ResponseEntity<ReviewClass> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		return new ResponseEntity<ReviewClass>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);

	}
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,@RequestBody ReviewClass review){
		
		boolean updateReview = reviewService.updateReview(companyId, reviewId, review);
		if(updateReview)
		return new ResponseEntity<String>("review updated successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("review not updated ",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
		boolean deleteReview = reviewService.deleteReview(companyId, reviewId);
		if(deleteReview)
			return new ResponseEntity<String>("Review delete Succesfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("review not delete",HttpStatus.NOT_FOUND);
		
	}

}
