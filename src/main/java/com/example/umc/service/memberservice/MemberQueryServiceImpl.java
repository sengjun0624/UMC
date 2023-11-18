package com.example.umc.service.memberservice;

import com.example.umc.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public boolean existMember(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
