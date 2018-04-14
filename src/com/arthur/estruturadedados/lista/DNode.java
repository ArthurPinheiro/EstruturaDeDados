package com.arthur.estruturadedados.lista;

public class DNode implements Position {
	
	private DNode prev, next;
	private Object element;
	
	public DNode(DNode newPrev, DNode newNext, Object elem) {
		prev = newPrev;
		next = newNext;
		element = elem;
	}

	@Override
	public Object element() throws InvalidPositionException {
		if((prev == null) && (next == null))
			throw new InvalidPositionException("Posição não está na lista");
		return element;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public DNode getPrev() {
		return prev;
	}
	
	public void setNext (DNode newNext) {
		next = newNext;
	}
	
	public void setPrev(DNode newPrev) {
		prev = newPrev;
	}
	
	public void setElement(Object newElement) {
		element = newElement;
	}

}
