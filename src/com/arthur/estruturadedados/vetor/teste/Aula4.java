package com.arthur.estruturadedados.vetor.teste;

import com.arthur.estruturadedados.vetor.Vetor;

public class Aula4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vetor vetor = new Vetor(5);

		vetor.adiciona("elemento 1");
		vetor.adiciona("elemento 2");
		vetor.adiciona("elemento 3");		
		
		System.out.println(vetor.tamanho());
		System.out.println(vetor.toString());
	} 
}
