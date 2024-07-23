package com.embarkx.Reviewms;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embarkx.Reviewms.DTO.ReviewWithCompanyDTO;

@RestController
@RequestMapping("/reviews")
public class reviewController {

	private ReviewService rs;

	public reviewController(ReviewService rs) {
		super();
		this.rs = rs;
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewWithCompanyDTO>> getAllReviews(@RequestParam long companyId)
	{
		
		return new ResponseEntity<>(rs.getAllReview(companyId),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam long companyId,@RequestBody Review review)
	{
		boolean isTrue = rs.addReview(companyId, review);
		if(isTrue)
			return new ResponseEntity<String>("Review Added successfully",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Review> getReview(@PathVariable long id)
	{
		Review review = rs.getReview(id);
		if(review!=null)
			return new ResponseEntity<Review>(review,HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable long id,@RequestBody Review review)
	{
		Review rev = rs.updateReview(id,review);
		if(rev!=null)
			return new ResponseEntity<Review>(rev,HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable long id)
	{
		boolean isReviewDeleted = rs.deleteReview(id);
		if(isReviewDeleted)
			return new ResponseEntity<String>("Review Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Review not found",HttpStatus.NOT_FOUND);
	}
}
