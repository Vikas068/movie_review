package com.project.movie_review.serviceimpl;

import com.project.movie_review.entity.Movie;
import com.project.movie_review.exception.MovieException;
import com.project.movie_review.repository.MovieRepository;
import com.project.movie_review.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImplementation implements MovieService
{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void updateMovie(int id,Movie movie) {
         Movie movie1=movieRepository.findById(id).get();
         movie1.setMovieGenre(movie.getMovieGenre());
         movie1.setCasting(movie.getCasting());
         movie1.setReviews(movie.getReviews());
         movie1.setRating(movie.getRating());
         movie1.setReleaseDate(movie.getReleaseDate());
         movieRepository.save(movie1);
    }

    @Override
    public void DeleteMovie(int id) throws MovieException {
       if(movieRepository.findById(id).get() != null ) {
           movieRepository.deleteById(id);
       }
       else {
           throw new MovieException("User is not present");
       }

    }

    @Override
    public List<Movie> searchByTitle(String Title) {
        return movieRepository.findByTitle(Title);
    }

    @Override
    public List<Movie> searchByGenre(String Genere) {
        return movieRepository.findByMovieGenre(Genere);
    }

    @Override
    public List<Movie> findTop5Rating() {

        List<Movie> movieList=movieRepository.findAll();
        if(!(CollectionUtils.isEmpty(movieList)))
        {
            //get the top 5 rated movies .
            List<Movie> movieGetList=movieList.stream().sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).map(m->m).collect(Collectors.toList());
            if(movieGetList.size() > 5)

                return movieGetList.subList(0,4);
            return movieGetList;
        }

        return new ArrayList<>();
    }
}
