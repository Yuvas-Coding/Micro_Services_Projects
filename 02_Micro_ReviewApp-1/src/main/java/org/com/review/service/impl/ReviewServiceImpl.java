package org.com.review.service.impl;

import java.util.List;

import org.com.review.entity.ReviewClass;
import org.com.review.repository.ReviewRepository;
import org.com.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public List<ReviewClass> getAllReviews(Long companyId) {
		// TODO Auto-generated method stub
		List<ReviewClass> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, ReviewClass reviews) {
		// TODO Auto-generated method stub

		if (companyId != null && reviews != null) {
			reviews.setCompanyId(companyId);
			reviewRepository.save(reviews);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ReviewClass getReview(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId).orElse(null);
	}

	@Override
	public boolean updateReview(Long reviewId, ReviewClass updatedReview) {

		ReviewClass review = reviewRepository.findById(reviewId).orElse(null);

		if (review != null) {
			review.setTitle(updatedReview.getTitle());
			review.setCompanyId(updatedReview.getCompanyId());
			review.setDescription(updatedReview.getDescription());
			review.setRating(updatedReview.getRating());
			reviewRepository.save(review);
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean deleteReview(Long reviewId) {
		// TODO Auto-generated method stub

		ReviewClass reviewClass = reviewRepository.findById(reviewId).orElse(null);
		if (reviewClass != null) {
			reviewRepository.delete(reviewClass);
			return true;
		}
		return false;
	}
}
