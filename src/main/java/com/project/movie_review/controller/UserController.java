package com.project.movie_review.controller;

import com.project.movie_review.entity.Movie;
import com.project.movie_review.entity.Review;
import com.project.movie_review.exception.MovieException;
import com.project.movie_review.repository.MovieRepository;
import com.project.movie_review.service.MovieService;
import com.project.movie_review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Autowired
    ReviewService reviewService;

    @PostMapping("/AddReview")
    public ResponseEntity addReviewMovie(@RequestBody Review review) throws MovieException {
                reviewService.addReview(review);
                return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping("/top5Movies")
    public List<Movie> getTop5Movie()
    {
        return  movieService.findTop5Rating();
    }


    @GetMapping("/searchByTitle/{title}")
    public List<Movie> getByTitle(@PathVariable String title)
    {
        return movieService.searchByTitle(title);
    }

}
