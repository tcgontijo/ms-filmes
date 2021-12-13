package com.iftm.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ratingsdataservice.models.Rating;
import com.iftm.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@GetMapping("/movies/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@GetMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
	}

}
