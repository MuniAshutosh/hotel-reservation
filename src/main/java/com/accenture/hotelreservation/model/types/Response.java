package com.accenture.hotelreservation.model.types;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(value = Include.NON_NULL)
public class Response {
	private LocalDateTime timeStamp;
	private Integer statusCode;
	private HttpStatus status;
	private String reason;
	private String message;
	private Map<?, ?> data;

}
