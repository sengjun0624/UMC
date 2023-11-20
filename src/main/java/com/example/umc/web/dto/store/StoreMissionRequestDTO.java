package com.example.umc.web.dto.store;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreMissionRequestDTO {
    @Getter
    public static class CreatDTO {
        @NotNull private Integer reward;

        @NotNull private LocalDate deadLine;

        @NotBlank private String missionSpec;
    }
}
