package com.iftm.movieinfoservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@GetMapping("/{movieId}")
	public List<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
		return Collections.singletonList(new Movie(movieId, "Nome de teste"));
	}

}
