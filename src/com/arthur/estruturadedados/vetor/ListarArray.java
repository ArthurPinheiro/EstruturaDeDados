package com.arthur.estruturadedados.vetor;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ListarArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> arraylist = new ArrayList<String>();
		
		arraylist.add("Arthur");
		arraylist.add("Pinheiro");
		arraylist.add("de");
		arraylist.add("Lima");
		
		System.out.println(arraylist);
		
		System.out.println(arraylist.size());
		
		System.out.println(arraylist.isEmpty());
		
		arraylist.remove(2);
		
		System.out.println(arraylist);		

	}

}
