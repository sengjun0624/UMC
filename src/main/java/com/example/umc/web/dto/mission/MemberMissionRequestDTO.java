package com.example.umc.web.dto.mission;

import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistMission;

import lombok.Getter;

public class MemberMissionRequestDTO {
    @Getter
    public static class ChallengeDTO {

        @ExistMember private Long memberId;

        @ExistMission private Long missionId;
    }
}
