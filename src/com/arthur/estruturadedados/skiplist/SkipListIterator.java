package com.arthur.estruturadedados.skiplist;

import java.util.Iterator;

public class SkipListIterator <E extends Comparable<E>> implements Iterator<E> {

	SkipList<E> list;
    Node<E> current;

    public SkipListIterator(SkipList<E> list) {
	this.list = list;
	this.current = list.getHead();
    }

    public boolean hasNext() {
	return current.nextNodes.get(0) != null;
    }

    public E next() {
	current = (Node<E>)current.nextNodes.get(0);
	return (E)current.getValue();
    }

    public void remove() throws UnsupportedOperationException {
	throw new UnsupportedOperationException();
  }
}
