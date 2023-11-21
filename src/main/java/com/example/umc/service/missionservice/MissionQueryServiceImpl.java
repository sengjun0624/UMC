package com.example.umc.service.missionservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.domain.Mission;
import com.example.umc.repository.MissionRepository;
import com.example.umc.web.dto.mission.MemberMissionRequestDTO.ChallengeDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission findMission(ChallengeDTO request) {
        return missionRepository.findById(request.getMissionId()).get();
    }

    @Override
    @Transactional
    public boolean existMission(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
