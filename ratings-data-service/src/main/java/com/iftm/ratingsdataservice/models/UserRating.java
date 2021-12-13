package com.iftm.ratingsdataservice.models;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

	private String userId;
	private List<Rating> ratings;

	public void initData(String userId) {
		this.setUserId(userId);
		this.setRatings(Arrays.asList(new Rating("550", 3), new Rating("268", 4), new Rating("78", 5)));
	}
}
