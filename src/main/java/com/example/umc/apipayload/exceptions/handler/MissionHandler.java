package com.example.umc.apipayload.exceptions.handler;

import com.example.umc.apipayload.code.BaseErrorCode;
import com.example.umc.apipayload.exceptions.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
