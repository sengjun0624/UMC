package com.example.umc.service.storeservice;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;

public interface StoreQueryService {
    Optional<Store> isExistStore(Long storeId);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
