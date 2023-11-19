package com.example.umc.service.foodservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.umc.repository.FoodCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Boolean isExistFoodCategory(List<Long> values) {
        return values.stream().allMatch(value -> foodCategoryRepository.existsById(value));
    }
}
