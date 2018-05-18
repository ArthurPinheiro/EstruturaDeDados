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
			// a SkipListNode with value null marks the beginning
			head = new Node<E>(null);
			// null marks the end
			head.nextNodes.add(null); 
		    }

	    public Node getHead() {
	    	return head;
	    }

	    // Adds e to the skiplist.
	    // Returns false if already in skiplist, true otherwise.
	    public boolean add(E e) {
			if(contains(e)) return false;
			size++;
			// random number from 0 to maxLevel+1 (inclusive)
			int level = 0; 
			while (Math.random() < PROBABILITY)
				level++;
			while(level > maxLevel) { // should only happen once
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

	    // Returns the skiplist node with greatest value <= e
	    private Node find(E e) {
	    	return find(e,head,maxLevel);
	    }

	    // Returns the skiplist node with greatest value <= e
	    // Starts at node start and level
	    private Node find(E e, Node current, int level) {
			
	    	do {
			    current = findNext(e,current,level);
			} while(level-- > 0);
			
	    	return current;
	    }

	    // Returns the node at a given level with highest value less than e
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
