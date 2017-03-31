package Poker;

import java.util.Stack;
import java.util.Collections;

public class Baralho {
	Stack<Carta> baralho = new Stack<Carta>();
	Stack<Carta> descarte = new Stack<Carta>();
	Carta carta;		
	
	/**
	 * Constrói um baralho ordenado e depois o embaralha.
	 */
	public Baralho(){
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 13 ; j++){
				carta = new Carta(j,i);
				baralho.push(carta);
			}
		}
		Collections.shuffle(baralho);
	}
	
	/**
	 * Método retira uma carta do topo do baralho 
	 */
	public Carta retirarBaralho(){
		return baralho.pop();
	}
	
	/**
	 *  Método recebe uma carta da mesa e a coloca na pilha de descarte
	 * @param carta
	 */
	public void descarteCarta(Carta carta){
		descarte.push(carta);
	}
	
}
