package jomily.anv.employees_skills.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SkillRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SkillErrorResponse> handleException(SkillNotFoundException exc) {

		SkillErrorResponse error = new SkillErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<SkillErrorResponse> handleException(Exception exc) {

		SkillErrorResponse error = new SkillErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
