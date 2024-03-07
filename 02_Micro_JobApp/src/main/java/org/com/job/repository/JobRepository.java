package org.com.job.repository;

import java.io.Serializable;

import org.com.job.entity.JobClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobClass, Serializable> {

}
