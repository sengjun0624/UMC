package com.example.umc.service.memberservice;

import com.example.umc.domain.Member;
import com.example.umc.web.dto.member.MemberRequestDTO;

public interface MemberCommandService {

	Member joinMember(MemberRequestDTO.JoinDto request);
}
