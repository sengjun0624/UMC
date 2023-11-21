package com.example.umc.web.dto.store;

import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistStore;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreReviewRequestDTO {

    @Getter
    public static class CreatReviewDTO {
        @ExistStore private Long storeId;

        @ExistMember private Long memberId;

        @NotBlank private String body;

        @DecimalMin("0")
        @DecimalMax("5.0")
        private float score;
    }
}
