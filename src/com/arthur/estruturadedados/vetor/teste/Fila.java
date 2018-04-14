package com.arthur.estruturadedados.vetor.teste;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> fila = new LinkedList<>();
		
		fila.add(6);
		fila.add(5);
		
		System.out.println(fila);		
		System.out.println(fila.peek());
		System.out.println(fila.remove());		
		System.out.println(fila);
		System.out.println(fila.isEmpty());
		System.out.println(fila.size());
	}

}
