package Poker;

import java.util.Arrays;

public class Combinacao {
	int valor;
	
	/**
	 * Construtor default só inicializa valor 
	 */
	public Combinacao(){
		this.valor = 0;
	}
	
	/**
	 * Getter
	 * @return valor
	 */
	public int getValor(){
		return this.valor;
	}
	
	/**
	 * Setter
	 * @param valor
	 */
	public void setValor(int valor){
		this.valor = valor;
	}
	
	private int pegaFrequenciaNaipeValor(Carta[] mesa,Carta carta){
		int frequencia = 0;
		for(int i = 0; i < 5 ; i++){
			if(carta.getNaipe() == mesa[i].getNaipe() && carta.getValorCarta() == mesa[i].getValorCarta()) frequencia++;
		}
		return frequencia;
	}
	
	/**
	 * Calcula a frequencia de uma carta na mesa a partir do valor ignorando o naipe.
	 * @param mesa
	 * @param carta
	 * @return A frequência da carta pelo valor.
	 */
	private int pegaFrequenciaValor(Carta[] mesa,Carta carta){
		int frequencia = 0;
		for(int i = 0; i < 5 ; i++){
			if(carta.getValorCarta() == mesa[i].getValorCarta()) frequencia++;
		}
		return frequencia;
	}
	
	/**
	 * Monta um vetor de frequencias pelo valor da cartas ignorando o naipe.
	 * @param mesa
	 * @return Vetor de frequencias de 5 posições
	 */
	private int[] vecFrequenciaValor(Carta[] mesa){
		int f[] = {0,0,0,0,0};
		for(int i = 0 ; i < 5 ; i++) f[i] = pegaFrequenciaValor(mesa,mesa[i]);
		return f;
	}
	
	/**
	 * Ordena o vetor de cartas pelo valor da carta usando bubblesort
	 * @param mesa
	 */
	private void bubbleSort(Carta[] mesa){
		for(int i = 1 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 - i ; j++){
				if(mesa[j].getValorCarta() > mesa[j+1].getValorCarta()){
					Carta aux;
					aux = mesa[j];
					mesa[j] = mesa[j+1];
					mesa[j+1] = aux;
				}
			}
		}
	}
	
	private int checaFullParTrincaQuadra(int[] f){
		int[] par = new int[2];
		int p = 0,t = 0,q = 0;
		
		for(int i = 0; i < 5 ; i++){
			if(f[i] == 2) par[p++] = i;
			if(f[i] == 3) t = 1;
			if(f[i] == 4) q = 1;			
		}
		
		/* Dois pares */
		if(p == 2 && par[0] != par[1]) return 0;
		/* Full House */
		if(t == 1 && p == 1) return 1;
		/* Trinca */
		if(t == 1 && p != 1) return 2;
		/* Quadra */
		if(q == 1) return 3;
		
		/* Nada */
		return -1;
		
	}
	
	public int checkCombination(Carta[] mesa){
		int f[] = vecFrequencia(mesa);
		
		switch(checaFullParTrincaQuadra(f)){
			case -1:
			/* Nada */
			break;
				
			case 0: /* Dois pares */
			return this.valor;
				
			case 1: /* Full House */
			return 20*this.valor;
				
			case 2: /* Trinca */
			return 2*this.valor;
			
			case 3: /* Quadra */
			return 4*this.valor;
		}
		
		
	}
	
}
