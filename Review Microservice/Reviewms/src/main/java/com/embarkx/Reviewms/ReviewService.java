package com.embarkx.Reviewms;

import java.util.List;

import com.embarkx.Reviewms.DTO.ReviewWithCompanyDTO;

public interface ReviewService {

	//List<Review> getAllReview(long companyId);
	
	List<ReviewWithCompanyDTO> getAllReview(long companyId);
	
	boolean addReview(long companyId,Review review);
	
	Review getReview(long id);
	
	Review updateReview(long id, Review review);
	
	boolean deleteReview(long id);
	
	
}
