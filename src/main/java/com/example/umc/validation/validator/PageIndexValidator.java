package com.example.umc.validation.validator;

import org.springframework.stereotype.Component;

import com.example.umc.apipayload.code.status.ErrorStatus;
import com.example.umc.service.storeservice.StoreQueryService;
import com.example.umc.validation.annotation.ValidPageIndex;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PageIndexValidator implements ConstraintValidator<ValidPageIndex, Integer> {
    StoreQueryService storeQueryService;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = value > 0;
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_VALID.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(ValidPageIndex constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
