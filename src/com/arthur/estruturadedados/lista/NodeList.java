package com.arthur.estruturadedados.lista;

public class NodeList implements List {
	
	protected int numElts;
	protected DNode header, trailer;
	
	public NodeList() {
		numElts = 0;
		header = new DNode(null, null, null);
		trailer = new DNode(header, null, null);
		header.setNext(trailer);
	}
	
	public int tamanho() {
		return this.tamanho();
	}
	
	public boolean isEmpty() {
		return numElts < 1;
	}

	@Override
	public boolean isFirst(Position P) throws InvalidPositionException {
		DNode v = checkPosition(P);
		return v.getPrev() == header;
		
	}

	private DNode checkPosition(Position p) throws InvalidPositionException {
		
		if(p == null) throw new InvalidPositionException("mensagem");
		
		if(p == header) throw new InvalidPositionException("mensagem");
		
		if(p == trailer)throw new InvalidPositionException("mensagem");
		
		try {
			DNode temp = (DNode) p;
			if((temp.getPrev() == null) || (temp.getNext() == null)) throw new InvalidPositionException("mensagem");
			return temp;
			
		} catch (ClassCastException e) {
			throw new InvalidPositionException("mensagem");
		}
		
	}

	@Override
	public boolean isLast(Position P) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Position first() throws EmptyContainerException {
		if(isEmpty()) throw new EmptyContainerException("Lista vazia");
		return header.getNext();
	}

	@Override
	public Position last() throws EmptyContainerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position before(Position p) throws InvalidPositionException, BoundaryViolationException {
		DNode v = checkPosition(p);
		DNode prev = v.getPrev();
		
		if(prev == header) throw new BoundaryViolationException("erro");
		return prev;
	}

	@Override
	public Position after(Position p) throws InvalidPositionException, BoundaryViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position insertBefore(Position p, Object element) throws InvalidPositionException {
		DNode v = checkPosition(p);
		numElts++;
		
		DNode newNode = new DNode(v.getPrev(), v, element);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		
		return newNode;
	}

	@Override
	public Position insertAfter(Position p, Object element) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position insertFirst(Object element) {
		numElts++;
		DNode newNode = new DNode(header, header.getNext(), element);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		return newNode;
	}

	@Override
	public Position insertLast(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replaceElement(Position p, Object element) throws InvalidPositionException {
		DNode v = checkPosition(p);
		Object oldElt = v.element();
		v.setElement(element);
		
		return oldElt;
	}

	@Override
	public void swapElements(Position a, Position b) throws InvalidPositionException {
		DNode pA = checkPosition(a);
		DNode pB = checkPosition(b);
		
		Object temp = pA.element();
		
		pA.setElement(pB.element());
		pB.setElement(temp);
		
	}
	
	public Object remove (Position p) throws InvalidPositionException {
		
		DNode v = checkPosition(p);
		numElts--;
		
		DNode vPrev = v.getPrev();
		DNode vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		
		Object vElem = v.element();
		
		v.setNext(null);
		v.setPrev(null);
		
		return vElem;
	}

}
