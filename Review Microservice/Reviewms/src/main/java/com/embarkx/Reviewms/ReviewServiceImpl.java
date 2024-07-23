package com.embarkx.Reviewms;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.embarkx.Reviewms.DTO.ReviewWithCompanyDTO;
import com.embarkx.Reviewms.external.External_Company;


@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepo repo;
	
	@Autowired 
	RestTemplate restTemplate; 
	 
	public ReviewServiceImpl(ReviewRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<ReviewWithCompanyDTO> getAllReview(long companyId) {
		List<Review> reviews = repo.findByCompanyId(companyId);
		
		return reviews.stream().map(this::ConvertToDTO).collect(Collectors.toList());
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

	public ReviewWithCompanyDTO ConvertToDTO(Review review) {

		//RestTemplate restTemplate = new RestTemplate();  
		External_Company comp = 
				restTemplate.getForObject("http://COMPANYMS:8081/companies/"+review.getCompanyId(), External_Company.class);
		
		ReviewWithCompanyDTO ReviewWithCompanyDTO = ReviewMapper.ReviewDTOMapper(review, comp);
		
		return ReviewWithCompanyDTO;
	}
	
	@Override

	 public Review getReview(long id) { Optional<Review> op = repo.findById(id);
	 Review review = op.get(); if(review != null) return review; else return null;
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
