package com.ambiasystems.aria.patient.response;

import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {

	private final String message;

	private final Map<String, String> fieldErrors;

}
