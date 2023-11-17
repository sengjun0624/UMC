package com.example.umc.service.storeservice;

import com.example.umc.domain.Store;
import com.example.umc.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    Store SaveStore(StoreRequestDTO.StoreSaveDto request);
}
