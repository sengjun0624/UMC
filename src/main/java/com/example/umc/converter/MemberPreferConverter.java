package com.example.umc.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.umc.domain.FoodCategory;
import com.example.umc.domain.mapping.MemberPrefer;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory -> MemberPrefer.builder().foodCategory(foodCategory).build())
                .collect(Collectors.toList());
    }
}
