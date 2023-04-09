package com.project.movie_review.controller;

import com.project.movie_review.entity.Movie;
import com.project.movie_review.exception.MovieException;
import com.project.movie_review.repository.MovieRepository;
import com.project.movie_review.repository.ReviewRepository;
import com.project.movie_review.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/addmovie")
    public ResponseEntity addMovie(@RequestBody Movie movie) throws MovieException {

            Movie movie1 = movieService.addMovie(movie);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/searchByTitle/{title}")
    public List<Movie> getByTitle(@PathVariable String title)
    {
        return movieService.searchByTitle(title);
    }

    @GetMapping("/searchByGenre/{genre}")
    public List<Movie> getByGenre(@PathVariable String Genre)
    {
        return movieService.searchByGenre(Genre);
    }

    @GetMapping("/top5Movies")
    public List<Movie> getTop5Movie()
    {
        return  movieService.findTop5Rating();
    }



}
