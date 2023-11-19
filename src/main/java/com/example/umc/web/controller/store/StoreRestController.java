package com.example.umc.web.controller.store;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.service.storeservice.StoreCommandService;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistStore;
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

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.StoreSaveResultDTO> save(
            @RequestBody @Valid StoreRequestDTO.StoreSaveDto request) {

        Store store = storeCommandService.SaveStore(request);

        return ApiResponse.onSuccess(StoreConverter.toStoreSaveResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreReviewResponseDTO.CreatReviewResultDTO> creat(
            @RequestBody @Valid StoreReviewRequestDTO.CreatReviewDTO request,
            @ExistMember @RequestParam(name = "memberId") Long memberId,
            @ExistStore @PathVariable(name = "storeId") Long storeId) {

        Review review = storeCommandService.creatReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreatReviewResultDTO(review));
    }
}
