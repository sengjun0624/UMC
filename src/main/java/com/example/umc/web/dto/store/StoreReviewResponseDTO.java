package com.example.umc.web.dto.store;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreReviewResponseDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class CreatReviewResultDTO {

        private Long reviewId;

        private LocalDateTime createdAt;
    }
}
