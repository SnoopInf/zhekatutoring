package com.sevenwonders.server.exceptions;

public class CardsGenerationException extends RuntimeException {
	private static final long serialVersionUID = -9168598965174127278L;
	
	public CardsGenerationException() {
		super();
	}
	
	public CardsGenerationException(String message) {
		super(message);
	}
	
	public CardsGenerationException(String message, Throwable cause) {
		super(message, cause);
	}
}
