package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.ResponseDTO;

@ControllerAdvice
public class ResExceptionHandler {
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseDTO<?> missingParameterException(MissingServletRequestParameterException ex) {
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(null).successYn(false).error(ex.getMessage()).build();
		return response;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseDTO<?> missingValueException(IllegalArgumentException ex) {
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(null).successYn(false).error(ex.getMessage()).build();
		return response;
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResponseDTO<?> missingValueException1(HttpRequestMethodNotSupportedException ex) {
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(null).successYn(false).error(ex.getMessage()).build();
		return response;
	}
}
