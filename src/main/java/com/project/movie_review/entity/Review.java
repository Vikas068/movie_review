package com.project.movie_review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieTitle;

    private int rating;

    private String review;

    private String userId;

    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name="movie_id")
    @JsonIgnore
    private Movie movie;
}
