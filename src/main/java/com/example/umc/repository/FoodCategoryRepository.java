package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {}
