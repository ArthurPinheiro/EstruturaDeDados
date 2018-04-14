package com.arthur.estruturadedados.fila;

import com.arthur.estruturadedados.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {

	public Fila() {
		super();
	}
	
	public Fila(int capacidade) {
		super(capacidade);
	}

	public void enfileira(T elemento) {
		this.adiciona(elemento);
	}
	
	public T espiar() {
		return this.elementos[0];
	}

	public T remove() {		
		final int POS = 0;
		
		if(estaVazia()) {
			return null;
		}
		
		T elementoRemovido = this.elementos[POS];
		this.remove(POS);
		
		return elementoRemovido;
	}
}
