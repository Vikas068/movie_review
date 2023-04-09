package com.project.movie_review.entity;

import com.project.movie_review.enums.MovieGenre;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;


    private MovieGenre movieGenre;

    private int rating;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    private Date releaseDate;

    private String casting;


}
