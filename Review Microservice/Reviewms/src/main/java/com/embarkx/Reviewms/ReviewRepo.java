package com.embarkx.Reviewms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long>{

	List<Review> findByCompanyId(long companyId);

}
