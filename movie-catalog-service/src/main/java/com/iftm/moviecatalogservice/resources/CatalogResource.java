package com.iftm.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iftm.moviecatalogservice.models.CatalogItem;
import com.iftm.moviecatalogservice.models.Movie;
import com.iftm.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("12", 4), new Rating("15", 7));
		
		//UserRating ratings = restTemplate.getForObject("hhtp://localhost:8083/raingsdata/users/" + userId, UserRating.class);

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Filmao", rating.getRating());
		}).collect(Collectors.toList());

	}

}
