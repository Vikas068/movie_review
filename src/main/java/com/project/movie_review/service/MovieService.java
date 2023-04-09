package com.project.movie_review.service;

import com.project.movie_review.entity.Movie;
import com.project.movie_review.exception.MovieException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


public interface MovieService {

     Movie addMovie(Movie movie);
     void updateMovie(int id,Movie movie);
     void DeleteMovie(int id) throws MovieException;
     List<Movie> searchByTitle(String Title);
     List<Movie> searchByGenre(String Genere);

     List<Movie> findTop5Rating();
}
