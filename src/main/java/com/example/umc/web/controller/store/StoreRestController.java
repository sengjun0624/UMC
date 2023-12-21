package com.example.umc.web.controller.store;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc.apipayload.ApiResponse;
import com.example.umc.converter.mission.MissionConverter;
import com.example.umc.converter.store.StoreConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.service.missionservice.MissionCommandService;
import com.example.umc.service.storeservice.StoreCommandService;
import com.example.umc.validation.annotation.ExistStore;
import com.example.umc.web.dto.store.StoreMissionRequestDTO;
import com.example.umc.web.dto.store.StoreMissionResponseDTO;
import com.example.umc.web.dto.store.StoreRequestDTO;
import com.example.umc.web.dto.store.StoreResponseDTO;
import com.example.umc.web.dto.store.StoreReviewRequestDTO;
import com.example.umc.web.dto.store.StoreReviewResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/reviews")
    public ApiResponse<StoreReviewResponseDTO.CreatReviewResultDTO> creatReview(
            @RequestBody @Valid StoreReviewRequestDTO.CreatReviewDTO request) {

        Review review = storeCommandService.creatReview(request);
        return ApiResponse.onSuccess(StoreConverter.toCreatReviewResultDTO(review));
    }

    @PostMapping("/missions")
    public ApiResponse<StoreMissionResponseDTO.CreatResultDTO> creatMission(
            @RequestBody @Valid StoreMissionRequestDTO.CreatDTO request) {

        Mission mission = missionCommandService.saveMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreatResultDTO(mission));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(
            summary = "특정 가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "COMMON200",
                description = "OK, 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "AUTH003",
                description = "access 토큰을 주세요!",
                content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "AUTH004",
                description = "acess 토큰 만료",
                content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "AUTH006",
                description = "acess 토큰 모양이 이상함",
                content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({@Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")})
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistStore @PathVariable(name = "storeId") Long storeId) {
        return null;
    }
}
