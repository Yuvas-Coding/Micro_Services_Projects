package org.com.review.service.impl;

import java.util.List;

import org.com.company.entity.CompanyEntity;
import org.com.company.service.CompanyService;
import org.com.review.entity.ReviewClass;
import org.com.review.repository.ReviewRepository;
import org.com.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	CompanyService companyService;

	@Override
	public List<ReviewClass> getAllReviews(Long companyId) {
		// TODO Auto-generated method stub
		List<ReviewClass> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, ReviewClass reviews) {
		// TODO Auto-generated method stub
		CompanyEntity company = companyService.getById(companyId);

		if (company != null) {
			reviews.setCompany(company);
			reviewRepository.save(reviews);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ReviewClass getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub

		List<ReviewClass> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, ReviewClass updatedReview) {

		if (companyService.getById(reviewId) != null) {

			updatedReview.setCompany(companyService.getById(companyId));
			updatedReview.setId(reviewId);

			reviewRepository.save(updatedReview);

			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if (companyService.getById(companyId) != null && reviewRepository.existsById(reviewId)) {
			ReviewClass review = reviewRepository.findById(reviewId).orElse(null);

			CompanyEntity company = review.getCompany();
			company.getReviews().remove(review);
			companyService.updateCompany(companyId, company);
			reviewRepository.deleteById(reviewId);
			return true;
		} else {
			return false;
		}
	}
}
