package com.tech.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.payloads.ApiResponse;

@RestControllerAdvice
public class GloabalExceptionHandler {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFound ex) {
		ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);

	}

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>> resourceNotFound(MethodArgumentNotValidException ex) {
			Map<String,String> map=new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach(error->{
					String field=((FieldError)error).getField();
					String message=error.getDefaultMessage();
				map.put(field, message)	;
			}
					);
			return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		}
		 @ExceptionHandler(Exception.class)
		    public ResponseEntity<ApiResponse> handleGeneralException(Exception ex) {
		    	ApiResponse apiResponse = new ApiResponse( "An unexpected error occurred: " + ex.getMessage(), false);
		        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 @ExceptionHandler(BadCredentialsException.class)
		   public ResponseEntity<ApiResponse> badcred(Exception ex) {
		    	ApiResponse apiResponse = new ApiResponse( "You have Entered Invalid Credentials: " + ex.getMessage(), false);
		        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		    }
		    


}
