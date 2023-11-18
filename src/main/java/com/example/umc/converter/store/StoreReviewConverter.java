package com.example.umc.converter.store;

import com.example.umc.domain.Review;
import com.example.umc.repository.MemberRepository;
import com.example.umc.web.dto.store.StoreReviewRequestDTO;
import com.example.umc.web.dto.store.StoreReviewResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreReviewConverter {

    private final MemberRepository memberRepository;

    public static StoreReviewResponseDTO.CreatReviewResultDTO toCreatReviewResultDTO(
            Review review) {

        return StoreReviewResponseDTO.CreatReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(StoreReviewRequestDTO.CreatReviewDTO request) {

        return Review.builder().body(request.getBody()).score(request.getScore()).build();
    }
}
