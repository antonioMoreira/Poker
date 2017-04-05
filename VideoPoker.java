package Poker;

import java.io.IOException;
import java.lang.String;

public class VideoPoker {
	
	private static void printComandos(){
		
		System.out.println("Comandos: ");
		System.out.println("Digite [0] para sair da mesa");
		System.out.println("Digite [1] para trocar cartas");
		System.out.println("Digite [2] para terminar rodada");
		
	}

	public static void main(String[] args) throws IOException {
		Mesa mesa = new Mesa();
		Combinacao comb = new Combinacao();
		String cartasTroca;
		int comando, aposta = 0, contadorRodada = 0;
			
		do{
			if(contadorRodada == 0){
				System.out.println("Você possui [" + mesa.getCreditos() + "] creditos");
				System.out.println("Digite o valor da aposta: ");
				aposta = mesa.apostar();
				System.out.println(mesa.toString());
			}
			
			System.out.println("Aposta :" + aposta);
			
			if(contadorRodada < 2){
				printComandos();
				comando = EntradaTeclado.leInt();
				contadorRodada++;
			}else comando = 2;			
			
			switch(comando){
				case 1:
					cartasTroca = EntradaTeclado.leString();
					mesa.trocarCartas(cartasTroca);	
					System.out.println(mesa.toString());
					break;
				case 2: //Fim de rodada
					comb.setValor(aposta);
					// ARRUMAR ISSO ↓
					mesa.receberCreditos(comb.checkCombination(mesa.getHand()));
					mesa.reembaralhar();
					contadorRodada = 0;
					//if(mesa.getCreditos() <= 0)comando = 0; // não precisa deste if
					break;
				default:
					System.out.println("Comando invalido");
					contadorRodada--;
					if(contadorRodada == 0)
						mesa.receberCreditos(aposta);
					break;
			}				
			
		}while(mesa.getCreditos() > 0 && comando != 0);
		
		System.out.println("Fim de jogo!");
		System.out.println("Você terminou com " + mesa.getCreditos() + " fichas.");
	
	}

}