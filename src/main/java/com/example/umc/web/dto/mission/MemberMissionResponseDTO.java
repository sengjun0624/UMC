package com.example.umc.web.dto.mission;

import java.time.LocalDateTime;

import com.example.umc.domain.enums.MissionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeResultDTO {

        private Long memberMissionId;

        private MissionStatus status;

        private LocalDateTime createdAt;
    }
}
