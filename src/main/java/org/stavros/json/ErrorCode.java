package org.stavros.json;

public enum ErrorCode {
	UNKNOWN(0),
	IO(1),
	INVALID_FORMAT(101),
	INVALID_CALL(102);
	
	private int code;
	public int getCode() {
		return this.code;
	}
	
	ErrorCode(int code) {
		this.code = code;
	}
}
