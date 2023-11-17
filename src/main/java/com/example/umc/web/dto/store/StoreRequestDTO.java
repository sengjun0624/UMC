package com.example.umc.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
	@Getter
	public static class StoreSaveDto {
		@NotBlank
		private String name;
		@NotNull
		private String address;

		private Float score;
		@NotNull
		private Long regionId;
	}
}
