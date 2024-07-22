package com.embarkx.Reviewms;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepo repo;
	
	

	public ReviewServiceImpl(ReviewRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Review> getAllReview(long companyId) {
		List<Review> reviews = repo.findByCompanyId(companyId);
		
		return reviews;
	}

	@Override
	public boolean addReview(long companyId, Review review) {
	
		if(companyId != 0L && review != null)
		{
			review.setCompanyId(companyId);
			repo.save(review);
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Review getReview(long id) {
			Optional<Review> op = repo.findById(id); 
			Review review = op.get();
			if(review != null)
				return review;
			else
				return null;
	}

	@Override
	public Review updateReview(long id, Review review) {
		
			Optional<Review> op = repo.findById(id);
			Review r = op.get();
			if(r != null) {
			r.setDescription(review.getDescription());
			r.setRating(review.getRating());
			r.setTitle(review.getTitle());
			repo.save(r);
			return r;
		}
		else
			return null;
	}

	@Override
	public boolean deleteReview(long id) {
		
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		
			return false;
	}

}
