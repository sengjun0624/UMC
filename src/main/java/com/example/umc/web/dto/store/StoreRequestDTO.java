package com.example.umc.web.dto.store;

import com.example.umc.validation.annotation.ExistRegion;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class StoreSaveDto {
        @NotBlank private String name;

        @NotNull private String address;

        @DecimalMin(value = "0.1")
        @DecimalMax(value = "5.0")
        private Float score;

        @NotNull @ExistRegion private Long regionId;
    }
}
