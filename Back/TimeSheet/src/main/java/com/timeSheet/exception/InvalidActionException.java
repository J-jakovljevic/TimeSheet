package com.timeSheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidActionException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidActionException(String message) {
        super(message);
    }
}
