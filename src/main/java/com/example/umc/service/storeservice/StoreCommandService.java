package com.example.umc.service.storeservice;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreReviewRequestDTO;

public interface StoreCommandService {

    Store SaveStore(StoreRequestDTO.StoreSaveDto request);

    Review creatReview(Long memberId, Long storeId, StoreReviewRequestDTO.CreatReviewDTO request);
}
