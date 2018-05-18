package com.arthur.estruturadedados.hash;

import java.lang.Comparable;
import com.arthur.estruturadedados.skiplist.Node;

public class Hash {
	
	private int tamAtual, tamMax;
	private Object[] keys;
	private Object[] valor;
	
	public Hash(int capacidade) {
		tamAtual = 0;
		tamMax = capacidade;
		keys = new Object[tamMax];
		valor = new Object[tamMax];
	}
	
	//Função para limpar a tabela de hash
	public void limparTabela() {
		tamAtual = 0;
		keys = new Object[tamMax];
		valor = new Object[tamMax];
	}
	
	//Tamanho da tabela
	public int getSize() {
		System.out.println(tamAtual);
		return tamAtual;
	}
	
	//Saber se está cheio
	public int isFull() {
		return tamAtual = tamMax;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	//verifica se a tabela contem a chave
	public boolean contains(Object key) {
		System.out.println(get(key));
		return get(key) != null;
	}
	
	//Obter código de uma chaves
	private int hash(Object key) {
		System.out.println(key.hashCode() % tamMax);
		return key.hashCode() % tamMax;
	}
	
	 private Node findNext(Object e, Node current, int level) {
	        Node next = (Node)current.nextNodes.get(level);
		while(next != null) {
		    Object value = (Object)next.getValue();
		    if(lessThan(e,value)) // e < value
			break;
		    current = next;
		    next = (Node)current.nextNodes.get(level);
		}
		return current;
 }
	
	  public void insert(Object key, Object val) {                
	        int tmp = hash(key);
	        int i = tmp;
	        do {
	            if (keys[i] == null){
	                keys[i] = key;
	                valor[i] = val;
	                tamAtual++;
	                System.out.println("hash.Hash.insert() == " + key + " -> " + val);
	                return;
	            }
	            if (keys[i].equals(key)){ 
	                valor[i] = val; 
	                return; 
	            }            
	            i = (i + 1) % tamMax;            
	        } while (i != tmp);       
	        
	}
	
	  public Object get(Object key) {
	        int i = hash(key);
	        while (keys[i] != null){
	            if (keys[i]==key)
	                return valor[i];
	            i = (i + 1) % tamMax;
	        }          
	        System.out.println("hash.Hash.get() == " + valor[i]);
	        return null;
	    }

	    public void remove(Object key) {
	        if (!contains(key)) {
	            return;
	        }
	        int i = hash(key);
	        
	        while (!key.equals(keys[i])){ 
	            i = (i + 1) % tamMax;
	        }
	        keys[i] = valor[i] = null;

	        for (i = (i + 1) % tamMax; keys[i] != null; i = (i + 1) % tamMax){
	            Object tmp1 = keys[i], tmp2 = valor[i];
	            keys[i] = valor[i] = null;
	            tamAtual--;  
	            insert(tmp1, tmp2);            
	        }
	        System.out.println("hash.Hash.remove() == " + key);
	        tamAtual--;        
	    }
	    
	    private boolean lessThan(Object a, Object b) {
	    	return a.compareTo(b) < 0;
	    }

	    private boolean equalTo(Object a, Object b) {
	    	return a.compareTo(b) == 0;
	    }

	    private boolean greaterThan(Object a, Object b) {
	    	return a.compareTo(b) > 0;
	    }


}
