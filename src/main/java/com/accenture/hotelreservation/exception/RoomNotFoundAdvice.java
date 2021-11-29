package com.accenture.hotelreservation.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.accenture.hotelreservation.model.types.Response;

@ControllerAdvice
public class RoomNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RoomNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  Response roomNotFoundHandler(RoomNotFoundException ex) {
	  return Response.builder().message(ex.getMessage()).timeStamp(LocalDateTime.now()).build();
  }
}
