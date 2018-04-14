package com.arthur.estruturadedados.lista;

public class BoundaryViolationException extends Exception {

	public BoundaryViolationException() {}
	
	public BoundaryViolationException(String mensagem) {
		super(mensagem);
	}
}
