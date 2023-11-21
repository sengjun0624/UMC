package com.example.umc.service.memberbmissionservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.converter.mission.MemberMissionConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.MissionRepository;
import com.example.umc.web.dto.mission.MemberMissionRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission challenge(MemberMissionRequestDTO.ChallengeDTO request) {
        Member member = memberRepository.findById(request.getMemberId()).get();
        Mission mission = missionRepository.findById(request.getMissionId()).get();

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMission.setMission(mission);
        memberMission.setMember(member);

        return memberMissionRepository.save(memberMission);
    }
}
