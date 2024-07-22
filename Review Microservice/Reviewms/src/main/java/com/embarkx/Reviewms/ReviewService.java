package com.embarkx.Reviewms;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReview(long companyId);
	
	boolean addReview(long companyId,Review review);
	
	Review getReview(long id);
	
	Review updateReview(long id, Review review);
	
	boolean deleteReview(long id);
	
}
