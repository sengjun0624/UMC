package com.example.umc.apipayload.exceptions.handler;

import com.example.umc.apipayload.code.BaseErrorCode;
import com.example.umc.apipayload.exceptions.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
