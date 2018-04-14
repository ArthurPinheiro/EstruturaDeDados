package com.arthur.estruturadedados.vetor.teste;

import com.arthur.estruturadedados.vetor.Generics;
import com.arthur.estruturadedados.vetor.ObjetoVetor;

public class Aula10 {

	public static void main(String[] args) {
		
		ObjetoVetor obj = new ObjetoVetor(3);
		
		obj.adiciona(8.5);
		obj.adiciona(6);
		obj.adiciona(55);		
		System.out.println(obj);
		
		obj.remove(1);		
		System.out.println(obj);
		
		obj.adiciona(1, 33);
		System.out.println(obj);
		
		System.out.println(obj.tamanho);
		
		obj.adiciona(-8);
		System.out.println(obj);
		
		obj.busca(9);
		
		Generics<String> generico = new Generics<String>(1); // Só aceita tipos Strings. Está usando generico

	}

}
