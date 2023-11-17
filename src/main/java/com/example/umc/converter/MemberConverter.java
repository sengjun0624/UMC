package com.example.umc.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.umc.domain.Member;
import com.example.umc.domain.enums.Gender;
import com.example.umc.web.dto.member.MemberRequestDTO;
import com.example.umc.web.dto.member.MemberResponseDTO;

public class MemberConverter {

	public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
		return MemberResponseDTO.JoinResultDTO.builder()
			.memberId(member.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public MemberConverter() {
	}

	public static Member toMember(MemberRequestDTO.JoinDto request) {

		Gender gender = null;

		switch (request.getGender()) {
			case 1:
				gender = Gender.MALE;
				break;
			case 2:
				gender = Gender.FEMALE;
				break;
			case 3:
				gender = Gender.NONE;
				break;
		}

		return Member.builder()
			.address(request.getAddress())
			.specAddress(request.getSpecAddress())
			.gender(gender)
			.name(request.getName())
			.memberPreferList(new ArrayList<>())
			.build();
	}
}
