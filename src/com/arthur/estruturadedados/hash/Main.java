package com.arthur.estruturadedados.hash;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Hash h = new Hash(8);
	        
	        h.insert(1, 1);
	        h.insert(2, "A");
	        h.insert(3, 5);
	        h.insert(4, 7);
	        h.remove(2);
	        h.insert(5, "D");
	        h.insert(6, "B");
	        h.insert(7, 10);
	        h.remove(6);
	        
	        h.getSize();
	}

}
