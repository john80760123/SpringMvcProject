package tw.leonchen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MySystemExceptionHadle {
	
	@ExceptionHandler(Exception.class)
    public Object processExeptionHandle(Exception e) {
    	String errMsg1 = "error:Exception";
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg1);
    }
	
}
