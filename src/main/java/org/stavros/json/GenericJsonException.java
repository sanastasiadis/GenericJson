package org.stavros.json;

public class GenericJsonException extends Throwable {
	
	private ErrorCode errorCode;
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}
	
	public GenericJsonException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
