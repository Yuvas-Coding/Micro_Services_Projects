package org.com.review.service;

import java.util.List;

import org.com.review.entity.ReviewClass;

public interface ReviewService {
	
	
	List<ReviewClass> getAllReviews(Long companyId);
	
	boolean addReview(Long companyId,ReviewClass reviews);
	
	
	ReviewClass getReview(Long companyId,Long reviewId);
	
	boolean updateReview(Long companyId,Long reviewId,ReviewClass review);
	
	boolean deleteReview(Long companyId,Long reviewId);
	
	
	
	

}
