package Poker;

import java.io.IOException;
import java.lang.String;

public class Mesa {
	private int creditos; 
	Baralho baralho = new Baralho();
	Carta[] hand = new Carta[5];
	
	public int getCreditos(){
		return this.creditos;
	}
	
	public Carta[] getHand(){
		return hand;
	}
	
	public Mesa(){
		this.creditos = 200;
		
		for(int i=0; i<5; i++)
			hand[i] = baralho.retirarBaralho();		
	}
	
	private void trocarCartas(boolean []vetorAux){
		
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
		int valorAposta;
		
		do{
			
			valorAposta = EntradaTeclado.leInt();
		}while(!(valorAposta < this.creditos && valorAposta > 0));
		
		this.creditos -= valorAposta;
		
		return valorAposta;					
	}
	
	public void receberCreditos(int creditos){
		this.creditos += creditos;		
	}
	
	public void reembaralhar(){
		for(int i=0; i<5; i++)
			baralho.descarteCarta(hand[i]);
		
		baralho.refazerBaralho();
	}
	
	
	
	/**
	 * Funcão sobrecarrega o metodo toString e retorna a string das cartas horizontalmente.
	 * @return string de desenho dos dados.
	 */
	@Override
	public java.lang.String toString(){
		String retorno = new String();
		String vecAux[] = new String[7];
		
		
		for(int i = 0 ; i < 7 ; i++){
			vecAux[i] = "";
			for(int j = 0; j < 5 ; j++){
				vecAux[i] += hand[j].toString().substring(11*i, (10*(i+1)) + i) + " ";
			//	System.out.println(hand[j].toString());
			}
			retorno += vecAux[i] + "\n";
			
		}
			
		return retorno;
	}
	
}
