package com.example.umc.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.MemberConverter;
import com.example.umc.domain.Member;
import com.example.umc.service.memberservice.MemberCommandService;
import com.example.umc.web.dto.member.MemberRequestDTO;
import com.example.umc.web.dto.member.MemberResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

	private final MemberCommandService memberCommandService;

	@PostMapping("/")
	public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
		@RequestBody @Valid MemberRequestDTO.JoinDto request) {
		Member member = memberCommandService.joinMember(request);
		return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
	}
}
