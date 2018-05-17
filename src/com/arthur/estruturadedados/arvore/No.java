package com.arthur.estruturadedados.arvore;

public class No {

	int valor;
	No noEsquerda; //apontador para esquerda
	No noDireita; //apontador para a direita
	
	public No (int valor) {
		this.valor = valor;
	}
	
	public static No raiz; //apontador para a raiz
	
	public static void inserir(int valor) {
		inserir(raiz, valor);
	}
	
	public static void inserir(No node, int valor) {
		if(node == null) {
			raiz = new No(valor);
		
		} else {
			if(valor < node.valor) {
				
				if(node.noEsquerda != null) {
					inserir(node.noEsquerda, valor);				
				}else {
					System.out.println("Inserindo " + valor + " a esquerda de " + node.valor);
					node.noEsquerda = new No(valor);
				}
				
			}else {
				if(node.noDireita != null) {
					inserir(node.noDireita, valor);
				}else {
					System.out.println("Inserindo " + valor + " a direita de " + node.valor);
					node.noDireita = new No(valor);
				}
			}
		}
	}
	
	public No removeValorMinimoDaArvore(No node) {
		if(node == null) {
			System.out.println("Erro");
		}else if(node.noEsquerda != null) {
			node.noEsquerda = removeValorMinimoDaArvore(noEsquerda);
			return node;
		}else {
			return node.noDireita;
		}
		
		return null;
	}
	
	public static void preOrdem(No node) {
		if(node != null) {
			System.out.println(node.valor + ", ");
			preOrdem(node.noEsquerda);
			preOrdem(node.noDireita);
		}
	}

	public static void posOrdem(No node) {
		if(node != null) {
			posOrdem(node.noEsquerda);
			posOrdem(node.noDireita);
			System.out.println(node.valor + ", ");
		}
	}

	public static void emOrdem(No node) {
		if(node != null) {
			emOrdem(node.noEsquerda);
			System.out.println(node.valor + ", ");
			emOrdem(node.noDireita);
		}
	}
	
	public String toString() {
		return null;
		
	}
}
