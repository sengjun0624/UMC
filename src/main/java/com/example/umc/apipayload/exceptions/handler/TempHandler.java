package com.example.umc.apipayload.exceptions.handler;

import com.example.umc.apipayload.code.BaseErrorCode;
import com.example.umc.apipayload.exceptions.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
