package com.example.umc.service.missionservice;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.mission.MemberMissionRequestDTO;

public interface MissionQueryService {
    public Mission findMission(MemberMissionRequestDTO.ChallengeDTO request);

    boolean existMission(Long missionId);
}
