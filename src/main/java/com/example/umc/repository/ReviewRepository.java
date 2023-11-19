package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {}
