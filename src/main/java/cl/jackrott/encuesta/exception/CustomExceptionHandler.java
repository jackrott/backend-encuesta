package cl.jackrott.encuesta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode("Exception");
		exceptionResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleCustomNotFoundException(CustomNotFoundException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		
		exceptionResponse.setCode(ErrorUtil.NOT_FOUND);
		exceptionResponse.setMessage(ex.getMessage());
        
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(value = MethodArgumentNotValidException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        ExceptionResponse exceptionResponse = new ExceptionResponse();
	        exceptionResponse.setCode(ErrorUtil.DTO_REQUEST_VALIDATION);
	        exceptionResponse.setMessage("Atributos no validos");
	        exceptionResponse.setValidationErrors(result);
	        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	    }
}
