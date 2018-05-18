package com.arthur.estruturadedados.skiplist;

import java.util.Iterator;

public class SkipList<E extends Comparable<E>>  {
	

	    private Node<E> head;
	    private int maxLevel;
	    private int size;

	    private static final double PROBABILITY = 0.5;

	    public SkipList() {
			size = 0;
			maxLevel = 0;
			head = new Node<E>(null);
			head.nextNodes.add(null); 
		    }

	    public Node getHead() {
	    	return head;
	    }

	    public boolean add(E e) {
			if(contains(e)) return false;
			size++;
			// numero aleatorio 0 a 1 
			int level = 0; 
			while (Math.random() < PROBABILITY)
				level++;
			while(level > maxLevel) { 
			    head.nextNodes.add(null);
			    maxLevel++;
			}
			
			Node newNode = new Node<E>(e);
			Node current = head;
			
		      	do {
			    current = findNext(e,current,level);
			    newNode.nextNodes.add(0,current.nextNodes.get(level));
			    current.nextNodes.set(level,newNode);
			} while (level-- > 0);
		      	
	      	return true;
	    }

	    // No com o maior valor
	    private Node find(E e) {
	    	return find(e,head,maxLevel);
	    }

	   
	    private Node find(E e, Node current, int level) {
			
	    	do {
			    current = findNext(e,current,level);
			} while(level-- > 0);
			
	    	return current;
	    }

	    private Node findNext(E e, Node current, int level) {
		        Node next = (Node)current.nextNodes.get(level);
			while(next != null) {
			    E value = (E)next.getValue();
			    if(lessThan(e,value)) // e < value
				break;
			    current = next;
			    next = (Node)current.nextNodes.get(level);
			}
			return current;
	    }
	    
	    public int size() {
	    	return size;
	    }

	    public boolean contains(Object o) {
			E e = (E)o;
			Node node = find(e);
			return node != null &&
			    node.getValue() != null &&
			    equalTo((E)node.getValue(),e);
	    }

	    public Iterator<E> iterator() {
	    	return new SkipListIterator(this);
	    }

	
	    private boolean lessThan(E a, E b) {
	    	return a.compareTo(b) < 0;
	    }

	    private boolean equalTo(E a, E b) {
	    	return a.compareTo(b) == 0;
	    }

	    private boolean greaterThan(E a, E b) {
	    	return a.compareTo(b) > 0;
	    }

}
