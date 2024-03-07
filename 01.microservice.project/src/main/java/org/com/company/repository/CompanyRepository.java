package org.com.company.repository;
//+=================
import java.io.Serializable;
import java.util.List;

import org.com.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompanyRepository extends JpaRepository<CompanyEntity, Serializable> {


}
