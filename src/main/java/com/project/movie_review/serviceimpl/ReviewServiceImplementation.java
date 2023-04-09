package com.project.movie_review.serviceimpl;

import com.project.movie_review.entity.Review;
import com.project.movie_review.repository.ReviewRepository;
import com.project.movie_review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
