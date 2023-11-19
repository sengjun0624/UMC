package com.example.umc.service.storeservice;

import java.util.Optional;

import com.example.umc.domain.Store;

public interface StoreQueryService {
    Optional<Store> isExistStore(Long storeId);
}
