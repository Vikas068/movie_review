package com.project.movie_review.repository;

import com.project.movie_review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

}
