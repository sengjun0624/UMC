package com.example.umc.web.dto.store;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreReviewRequestDTO {

    @Getter
    public static class CreatReviewDTO {

        @NotBlank private String body;

        @DecimalMin("0")
        @DecimalMax("5.0")
        private float score;
    }
}
