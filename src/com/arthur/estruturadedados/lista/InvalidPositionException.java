package com.arthur.estruturadedados.lista;

public class InvalidPositionException extends Exception {

	public InvalidPositionException() {}
	
	public InvalidPositionException(String mensagem) {
		super(mensagem);
	}
}
