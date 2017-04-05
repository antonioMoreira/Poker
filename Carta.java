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

	/**
	 * 
	 * @return retorna o valor da carta [0,12]
	 */
	public int getValorCarta(){
		return this.valorCarta;
	}

	/**
	 * 
	 * @return retorna o naipe da carta[0,3]
	 */
	public int getNaipe(){
		return this.naipe;
	}
	
	
	public String toString(){
		String result;
		int j;
		
		result = new String();
		char c = 0;
		
		switch(this.naipe){
			case 0: /* Copas */
				
				j = this.valorCarta + 50;

				if(this.valorCarta<9){					
				c = (char) (j);
				}else{
					switch(this.valorCarta){
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
						default:
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
			
			return result;
				
			case 1: /* Paus */
				
				j = this.valorCarta + 50;

				if(this.valorCarta<9){					
				c = (char) (j);
				}else{
					switch(this.valorCarta){
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
						default:
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

			return result;
			
			case 2: /* Ouro */
				
	
				j = this.valorCarta + 50;

				if(this.valorCarta<9){					
				c = (char) (j);
				}else{
					switch(this.valorCarta){
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
						default:
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

			return result;
			
			case 3: /* Espada */
				
				j = this.valorCarta + 50;

				if(this.valorCarta<9){					
				c = (char) (j);
				}else{
					switch(this.valorCarta){
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
						default:
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


			return result;				
		}
		
		return result;	
	}
	
}
