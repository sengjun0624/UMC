package com.example.umc.service.memberservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.apipayload.code.status.ErrorStatus;
import com.example.umc.apipayload.exceptions.handler.FoodCategoryHandler;
import com.example.umc.converter.member.MemberConverter;
import com.example.umc.converter.member.MemberPreferConverter;
import com.example.umc.domain.FoodCategory;
import com.example.umc.domain.Member;
import com.example.umc.domain.mapping.MemberPrefer;
import com.example.umc.repository.FoodCategoryRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.web.dto.member.MemberRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList =
                request.getPreferCategory().stream()
                        .map(
                                category -> {
                                    return foodCategoryRepository
                                            .findById(category)
                                            .orElseThrow(
                                                    () ->
                                                            new FoodCategoryHandler(
                                                                    ErrorStatus
                                                                            .FOOD_CATEGORY_NOT_FOUND));
                                })
                        .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList =
                MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(
                memberPrefer -> {
                    memberPrefer.setMember(newMember);
                });

        return memberRepository.save(newMember);
    }
}
