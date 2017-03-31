package Poker;

import java.lang.String;

public class Carta {
	private int valorCarta;
	private int naipe;
	
	/**
	 * Contrutor com argumentos.
	 * @param valorCarta
	 * 		Um nº no intervalo [0,12] que representa o valor da carta no intervalo [2,Ás]
	 * @param nipe
	 * 		Um inteiro que representa o naipe da carta. 0 → copas; 1 → paus; 2 → ouro; 3 → espada 
	 */
	public Carta(int valorCarta, int naipe){
		this.valorCarta = valorCarta;
		this.naipe = naipe;		
	}

	public int getValorCarta(){
		return this.valorCarta;
	}

	public int getNaipe(){
		return this.naipe;
	}

	public String toString(){
		
		
		
		return null;
	}	
	
}