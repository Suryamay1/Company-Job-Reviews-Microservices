package com.embarkx.Reviewms;

import com.embarkx.Reviewms.DTO.ReviewWithCompanyDTO;
import com.embarkx.Reviewms.external.External_Company;

public class ReviewMapper {

	public static ReviewWithCompanyDTO ReviewDTOMapper(Review review,External_Company comp) {
		
		ReviewWithCompanyDTO ReviewWithCompanyDTO = new ReviewWithCompanyDTO();
		
		ReviewWithCompanyDTO.setId(review.getId());
		ReviewWithCompanyDTO.setTitle(review.getTitle());
		ReviewWithCompanyDTO.setDescription(review.getDescription());
		ReviewWithCompanyDTO.setRating(review.getRating());
		ReviewWithCompanyDTO.setComp(comp);
		
		return ReviewWithCompanyDTO;
	}
}
