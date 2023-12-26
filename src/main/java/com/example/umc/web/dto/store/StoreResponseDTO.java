package com.example.umc.web.dto.store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreSaveResultDTO {

        private Long storeId;

        LocalDateTime createdAt;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;

        Integer listSize;

        Integer totalPage;

        Long totalElements;

        Boolean isFirst;

        Boolean isLast;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ReviewPreViewDTO {
        // member info
        String ownerNickname;

        // review info
        Float score;

        String body;

        LocalDate createdAt;
    }
}
