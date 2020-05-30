package cl.jackrott.encuesta.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ExceptionResponse {

	private String code;
	private String message;
	private List<subError> subErrors = new ArrayList<>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<subError> getSubErrors() {
		return subErrors;
	}
	
	public void setValidationErrors(Errors errors) {
		List<FieldError> fieldErrors = errors.getFieldErrors();
		fieldErrors.forEach(f -> subErrors.add(new subError(f.getObjectName(), f.getField(), f.getDefaultMessage(), f.getRejectedValue())));
	}
	
	class subError {
		String object;
		String field;
		String message;
		Object rejectedValue;
		public subError(String object, String field, String message, Object rejectedValue) {
			super();
			this.object = object;
			this.field = field;
			this.message = message;
			this.rejectedValue = rejectedValue;
		}
		public String getObject() {
			return object;
		}
		public void setObject(String object) {
			this.object = object;
		}
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Object getRejectedValue() {
			return rejectedValue;
		}
		public void setRejectedValue(Object rejectedValue) {
			this.rejectedValue = rejectedValue;
		}
	}

}
