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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class reviewController {

	private ReviewService rs;

	public reviewController(ReviewService rs) {
		super();
		this.rs = rs;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable long companyId)
	{
		
		return new ResponseEntity<>(rs.getAllReview(companyId),HttpStatus.OK);
	}
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable long companyId,@RequestBody Review review)
	{
		boolean isTrue = rs.addReview(companyId, review);
		if(isTrue)
			return new ResponseEntity<String>("Review Added successfully",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/review/{id}")
	public ResponseEntity<Review> getReview(@PathVariable long companyId, @PathVariable long id)
	{
		Review review = rs.getReview(companyId,id);
		if(review!=null)
			return new ResponseEntity<Review>(review,HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/review/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable long companyId, @PathVariable long id,@RequestBody Review review)
	{
		Review rev = rs.updateReview(companyId,id,review);
		if(rev!=null)
			return new ResponseEntity<Review>(rev,HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable long companyId,@PathVariable long id)
	{
		boolean isReviewDeleted = rs.deleteReview(companyId,id);
		if(isReviewDeleted)
			return new ResponseEntity<String>("Review Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Review not found",HttpStatus.NOT_FOUND);
	}
}
