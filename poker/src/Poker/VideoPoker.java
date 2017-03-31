package Poker;

import java.io.IOException;

public class VideoPoker {
	
	private static void printMenu(){
		
		System.out.println("MENU: ");
		System.out.println("Digite [0] para sair da mesa");
		System.out.println("Digite [1] para trocar cartas");
		System.out.println("Digite [2] para terminar rodada");
		
	}

	public static void main(String[] args) throws IOException {
		Mesa mesa = new Mesa();
		Combinacao comb = new Combinacao();
		int comando;
		
		do{
			System.out.println(mesa.toString());
			
			printMenu();
			
			comando = EntradaTeclado.leInt();
			
			switch(comando){
				case 1:
					
					break;
				case 2:
					break;	
			
			
			}
			
			
			
			
			
			
			
		}while(mesa.getCreditos() > 0 || comando != 0);
		
		
		

	}

}
