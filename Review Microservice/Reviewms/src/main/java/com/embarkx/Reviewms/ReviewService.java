package com.embarkx.Reviewms;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReview(long companyId);
	boolean addReview(long companyId,Review review);
	Review getReview(long companyId, long id);
	Review updateReview(long companyId, long id, Review review);
	boolean deleteReview(long companyId, long id);
}
