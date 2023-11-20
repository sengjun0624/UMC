package com.example.umc.converter.mission;

import java.time.LocalDateTime;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.store.StoreMissionRequestDTO;
import com.example.umc.web.dto.store.StoreMissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(StoreMissionRequestDTO.CreatDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadLine())
                .build();
    }

    public static StoreMissionResponseDTO.CreatResultDTO toCreatResultDTO(Mission mission) {
        return StoreMissionResponseDTO.CreatResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
