package com.arthur.estruturadedados.lista;

public class EmptyContainerException extends Exception {

	public EmptyContainerException() {}
	
	public EmptyContainerException(String mensagem) {
		super(mensagem);
	}
}
