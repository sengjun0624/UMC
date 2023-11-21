package com.example.umc.service.missionservice;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.store.StoreMissionRequestDTO;

public interface MissionCommandService {
    public Mission saveMission(StoreMissionRequestDTO.CreatDTO request);
}
