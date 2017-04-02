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
		String result;
		
		result = new String();
		char c = 0;
		
		switch(this.naipe){
			case 0: /* Copas */
				
				
				for(int i = 0 ; i < 13 ;i++){
					int j = i + 50;
					
					if(i < 9 && i == valorCarta){
						c = (char) (j);
					}else{
						switch(i){
							case 9:
								c = 'J';
							break;
							case 10:
								c = 'Q';
							break;
							case 11:
								c = 'K';
							break;
							case 12:
								c = 'A';
							break;
						
							
						}
					}
					result = "*--------*\n";
					if(c!=58)result += "|♥      " + c +"|\n";
					else result += "|♥     " + 10 +"|\n";
					result += "|        |\n" + "|        |\n" + "|        |\n";
					if(c!=58) result += "|" + c + "      ♥|\n";
					else result += "|" + 10 + "     ♥|\n";
					result += "*--------*\n";
					if(c !=0) break;
					else result = "";
				}
			return result;
				
			case 1: /* Paus */
				
	
				for(int i = 0 ; i < 13 ;i++){
					int j = i + 50;
					if(i < 9 && i == valorCarta){
						c = (char) (j);
					}else{
						switch(i){
							case 9:
								c = 'J';
							break;
							case 10:
								c = 'Q';
							break;
							case 11:
								c = 'K';
							break;
							case 12:
								c = 'A';
							break;
							
							
						}
						
					}
					
					result = "*--------*\n";
					if(c!=58)result += "|♣      " + c +"|\n";
					else result += "|♣     " + 10 +"|\n";
					result += "|        |\n" + "|        |\n" + "|        |\n";
					if(c!=58) result += "|" + c + "      ♣|\n";
					else result += "|" + 10 + "     ♣|\n";
					result += "*--------*\n";
					if(c != 0) break;
					else result = "";
				}
			return result;
			
			case 2: /* Ouro */
				
	
				for(int i = 0 ; i < 13 ;i++){
					int j = i + 50;
					if(i < 9 && i == valorCarta){
						c = (char) (j);
					}else{
						switch(i){
							case 9:
								c = 'J';
							break;
							case 10:
								c = 'Q';
							break;
							case 11:
								c = 'K';
							break;
							case 12:
								c = 'A';
							break;
							
						}
						
					}
					
					result = "*--------*\n";
					if(c!=58)result += "|♦      " + c +"|\n";
					else result += "|♦    " + 10 +"|\n";
					result += "|        |\n" + "|        |\n" + "|        |\n";
					if(c!=58)result += "|" + c + "      ♦|\n";
					else result += "|" + 10 + "    ♦|\n";
					result += "*--------*\n";
					if(c !=0) break;
					else result = "";
				}
			return result;
			
			case 3: /* Espada */
				result = "*--------*\n";
	
				for(int i = 0 ; i < 13 ;i++){
					int j = i + 50;
					if(i < 9 && i == valorCarta){
						c = (char) (j);
					}else{
						switch(i){
							case 9:
								c = 'J';
							break;
							case 10:
								c = 'Q';
							break;
							case 11:
								c = 'K';
							break;
							case 12:
								c = 'A';
							break;
						}
						
					}
					
					result = "*--------*\n";
					if(c!=58)result += "|♠      " + c + "|\n";
					else result += "|♠     " + 10 + "|\n";
					result += "|        |\n" + "|        |\n" + "|        |\n";
					if(c!=58) result += "|" + c + "      ♠|\n";
					else result += "|" + 10 + "     ♠|\n";
					result += "*--------*\n";
					if(c !=0) break;
					else result = "";
				}
			return result;				
		}
		
		return result;	
	}
	
}
