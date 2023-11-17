package com.example.umc.converter.store;

import java.time.LocalDateTime;

import com.example.umc.domain.Store;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.StoreSaveResultDTO storeSaveResultDTO(Store store) {
        return StoreResponseDTO.StoreSaveResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreSaveDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
