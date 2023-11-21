package com.example.umc.service.storeservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Region;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.RegionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreReviewRequestDTO.CreatReviewDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Store SaveStore(StoreRequestDTO.StoreSaveDto request) {

        Store newStore = StoreConverter.toStore(request);

        Region newRegion = regionRepository.findById(request.getRegionId()).get();

        newStore.setRegion(newRegion);
        return storeRepository.save(newStore);
    }

    @Override
    public Review creatReview(Long memberId, Long storeId, CreatReviewDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());
        return review;
    }
}
