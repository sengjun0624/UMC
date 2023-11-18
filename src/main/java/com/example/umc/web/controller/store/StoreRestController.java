package com.example.umc.web.controller.store;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Store;
import com.example.umc.service.storeservice.StoreCommandService;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreResponseDTO;

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
}
