package com.example.umc.web.controller.store;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.mission.MissionConverter;
import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.service.missionservice.MissionCommandService;
import com.example.umc.service.storeservice.StoreCommandService;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistStore;
import com.example.umc.web.dto.store.StoreMissionRequestDTO;
import com.example.umc.web.dto.store.StoreMissionResponseDTO;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreResponseDTO;
import com.example.umc.web.dto.store.StoreReviewRequestDTO;
import com.example.umc.web.dto.store.StoreReviewResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.StoreSaveResultDTO> save(
            @RequestBody @Valid StoreRequestDTO.StoreSaveDto request) {

        Store store = storeCommandService.SaveStore(request);

        return ApiResponse.onSuccess(StoreConverter.toStoreSaveResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreReviewResponseDTO.CreatReviewResultDTO> creatReview(
            @RequestBody @Valid StoreReviewRequestDTO.CreatReviewDTO request,
            @ExistMember @RequestParam(name = "memberId") Long memberId,
            @ExistStore @PathVariable(name = "storeId") Long storeId) {

        Review review = storeCommandService.creatReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreatReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreMissionResponseDTO.CreatResultDTO> creatMission(
            @RequestBody @Valid StoreMissionRequestDTO.CreatDTO request) {

        Mission mission = missionCommandService.saveMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreatResultDTO(mission));
    }
}
