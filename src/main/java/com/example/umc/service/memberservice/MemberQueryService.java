package com.example.umc.service.memberservice;

import com.example.umc.domain.Member;

public interface MemberQueryService {
    boolean existMember(Long memberId);

    Member findMember(Long memberId);
}
