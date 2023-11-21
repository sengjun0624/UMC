package com.example.umc.validation.validator;

import org.springframework.stereotype.Component;

import com.example.umc.apipayload.code.status.ErrorStatus;
import com.example.umc.service.missionservice.MissionQueryService;
import com.example.umc.validation.annotation.ExistMission;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {
    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionQueryService.existMission(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }
}
