package Poker;

import java.io.IOException;
import java.lang.String;

public class Mesa {
	private int creditos; 
	Baralho baralho = new Baralho();
	Carta[] hand = new Carta[5];
	
	public Mesa(){
		this.creditos = 200;
		
		for(int i=0; i<5; i++)
			hand[i] = baralho.retirarBaralho();		
	}
	
	public void trocarCartas(boolean []vetorAux){
		
		for(int i=0; i<5; i++){
			if(vetorAux[i]){
				baralho.descarteCarta(hand[i]);
				hand[i] = baralho.retirarBaralho();				
			}			
		}		
	}
	
	public void trocarCartas(String quais){
		boolean []vetorAux = new boolean[5]; 
		int stringLenght = quais.length(), numericValue;
		char c;
		
		for(int i=0; i<5; i++) vetorAux[i] = false;
		
		for(int i=0; i< stringLenght; i++){
			c = quais.charAt(i);
			
			numericValue = Character.getNumericValue(c);
			
			if(numericValue > 0 && numericValue < 6)
				vetorAux[numericValue-1] = true;
					
		}
		
		trocarCartas(vetorAux);
	}
	
	public int apostar() throws IOException{
		int valorAposta = EntradaTeclado.leInt();
		
		if(valorAposta < this.creditos){
			this.creditos -= valorAposta;
			return valorAposta;			
		}		
		
		return -1;
	}
	
	public void receberCreditos(int creditos){
		this.creditos += creditos;		
	}
	
	public void reembaralhar(){
		for(int i=0; i<5; i++)
			baralho.descarteCarta(hand[i]);
		
		//baralho.refazerBaralho();
	}
	
	public String toString(){
		
		
		
		return null;
	}
	
}