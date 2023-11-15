package com.example.umc.apipayload.exceptions.handler;

import com.example.umc.apipayload.code.BaseErrorCode;

public class TempHandler extends GeneralException {

	public TempHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
