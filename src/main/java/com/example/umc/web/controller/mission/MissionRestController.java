package com.example.umc.web.controller.mission;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.mission.MemberMissionConverter;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.service.memberbmissionservice.MemberMissionCommandService;
import com.example.umc.web.dto.mission.MemberMissionRequestDTO;
import com.example.umc.web.dto.mission.MemberMissionResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResultDTO> challenge(
            @RequestBody @Valid MemberMissionRequestDTO.ChallengeDTO request) {
        MemberMission memberMission = memberMissionCommandService.challenge(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }
}
