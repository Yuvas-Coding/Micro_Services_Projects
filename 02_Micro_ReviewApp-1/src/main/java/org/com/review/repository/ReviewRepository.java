package org.com.review.repository;

import java.io.Serializable;
import java.util.List;

import org.com.review.entity.ReviewClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewClass , Serializable> {

	List<ReviewClass> findByCompanyId(Long companyId);

}
