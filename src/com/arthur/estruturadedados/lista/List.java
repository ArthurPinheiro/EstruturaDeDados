package com.arthur.estruturadedados.lista;

public interface List {
	
	public boolean isFirst(Position P) throws InvalidPositionException;
	public boolean isLast(Position P) throws InvalidPositionException;
	public Position first() throws EmptyContainerException; 
	public Position last() throws EmptyContainerException; 
	public Position before(Position p) throws InvalidPositionException, BoundaryViolationException;
	public Position after(Position p) throws InvalidPositionException, BoundaryViolationException;
	public Position insertBefore(Position p, Object element) throws InvalidPositionException;
	public Position insertAfter(Position p, Object element) throws InvalidPositionException;
	public Position insertFirst(Object element);
	public Position insertLast(Object element);
	public Object replaceElement(Position p, Object element) throws InvalidPositionException;
	public void swapElements(Position a, Position b) throws InvalidPositionException;

}
