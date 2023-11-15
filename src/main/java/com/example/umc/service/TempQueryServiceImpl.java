package com.example.umc.service;

import org.springframework.stereotype.Service;

import com.example.umc.apipayload.code.status.ErrorStatus;
import com.example.umc.apipayload.exceptions.handler.TempHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
