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
		//Carta carta = new Carta(0,1);
		//	System.out.println(carta.toString());
		
		do{
			if(contadorRodada == 0){
				System.out.println("Digite o valor da aposta: ");
				aposta = mesa.apostar();
			
				System.out.println("Você possui [" + mesa.getCreditos() + "] creditos");
				System.out.println(mesa.toString());
			}
				
			if(contadorRodada < 3){
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
					mesa.receberCreditos(comb.checkCombination(mesa.getHand()));
					mesa.reembaralhar();
					contadorRodada = 0;
					break;
				default:
					System.out.println("Comando invalido");
					contadorRodada--;
					break;
			}				
			
		}while(mesa.getCreditos() > 0 || comando != 0);
		
		System.out.println("Fim de jogo!");
		System.out.println("Você terminou com " + mesa.getCreditos() + "fichas.");
	
	}

}