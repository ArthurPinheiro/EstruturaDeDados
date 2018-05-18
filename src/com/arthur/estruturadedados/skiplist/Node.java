package com.arthur.estruturadedados.skiplist;

import java.util.ArrayList;
import java.util.List;


public class Node<E> {
	
	private E value;
	public List <Node<E>> nextNodes;
	
	public E getValue() {
		return value;
	}
	
	public Node(E value) {
		this.value = value;
		nextNodes = new ArrayList<Node<E>>();
	}
	
	public int level() {
	   return nextNodes.size()-1;
	}

	public String toString() {
		return "SLN: " + value;
	}

}
