package com.example.umc.service.storeservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.apipayload.code.status.ErrorStatus;
import com.example.umc.apipayload.exceptions.handler.RegionHandler;
import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Region;
import com.example.umc.domain.Store;
import com.example.umc.repository.RegionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.store.StoreRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store SaveStore(StoreRequestDTO.StoreSaveDto request) {
        Store newStore = StoreConverter.toStore(request);

        Region newRegion =
                regionRepository
                        .findById(request.getRegionId())
                        .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        newStore.setRegion(newRegion);

        return storeRepository.save(newStore);
    }
}
