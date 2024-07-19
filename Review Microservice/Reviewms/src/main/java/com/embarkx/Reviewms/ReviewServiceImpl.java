package com.embarkx.Reviewms;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.MicroservicesSpring.Company.CompService;
import com.embarkx.MicroservicesSpring.Company.Company;
import com.embarkx.MicroservicesSpring.review.Review;
import com.embarkx.MicroservicesSpring.review.ReviewRepo;
import com.embarkx.MicroservicesSpring.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepo repo;
	private final CompService compservice;
	
	

	public ReviewServiceImpl(ReviewRepo repo,CompService compservice) {
		super();
		this.repo = repo;
		this.compservice = compservice;
	}

	@Override
	public List<Review> getAllReview(long companyId) {
		List<Review> reviews = repo.findByCompanyId(companyId);
		
		return reviews;
	}

	@Override
	public boolean addReview(long companyId, Review review) {
		Company comp = compservice.getCompanyById(companyId);
		if(comp!=null)
		{
			review.setCompany(comp);
			repo.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReview(long companyId, long id) {
		if(compservice.getCompanyById(companyId)!=null)
		{
			Optional<Review> op = repo.findById(id); 
			Review review = op.get();
			return review;
		}
		else
			return null;
	}

	@Override
	public Review updateReview(long companyId, long id, Review review) {
		
		if(compservice.getCompanyById(companyId)!=null)
		{
			Optional<Review> op = repo.findById(id);
			Review r = op.get();
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
	public boolean deleteReview(long companyId, long id) {
		
		if(compservice.getCompanyById(companyId)!=null && repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		else
			return false;
	}

}
