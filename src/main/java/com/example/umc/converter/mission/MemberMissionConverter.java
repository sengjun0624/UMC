package com.example.umc.converter.mission;

import java.time.LocalDateTime;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.mission.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission) {

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(
            MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
