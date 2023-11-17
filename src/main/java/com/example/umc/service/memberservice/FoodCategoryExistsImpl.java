package com.example.umc.service.memberservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.umc.repository.FoodCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodCategoryExistsImpl implements FoodCategoryExists {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Boolean isExistFoodCategory(List<Long> values) {
        return values.stream().allMatch(value -> foodCategoryRepository.existsById(value));
    }
}
