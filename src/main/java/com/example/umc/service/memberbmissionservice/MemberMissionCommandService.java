package com.example.umc.service.memberbmissionservice;

import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.mission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission challenge(MemberMissionRequestDTO.ChallengeDTO request);
}
