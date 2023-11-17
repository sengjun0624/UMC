package com.example.umc.apipayload.exceptions.handler;

import com.example.umc.apipayload.code.BaseErrorCode;
import com.example.umc.apipayload.exceptions.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
