package com.example.umc.converter.store;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreResponseDTO;
import com.example.umc.web.dto.store.StoreReviewRequestDTO;
import com.example.umc.web.dto.store.StoreReviewResponseDTO;
import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.StoreSaveResultDTO toStoreSaveResultDTO(Store store) {

        return StoreResponseDTO.StoreSaveResultDTO.builder()
                                                  .storeId(store.getId())
                                                  .createdAt(LocalDateTime.now())
                                                  .build();
    }

    public static Store toStore(StoreRequestDTO.StoreSaveDto request) {

        return Store.builder()
                    .name(request.getName())
                    .address(request.getAddress())
                    .score(request.getScore())
                    .build();
    }

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
