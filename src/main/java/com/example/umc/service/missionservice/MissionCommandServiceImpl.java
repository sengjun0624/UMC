package com.example.umc.service.missionservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc.converter.mission.MissionConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.repository.MissionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.store.StoreMissionRequestDTO.CreatDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {
    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    @Transactional
    @Override
    public Mission save(CreatDTO request, Long storeId) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(storeId).get();
        mission.setStore(store);

        return missionRepository.save(mission);
    }
}
