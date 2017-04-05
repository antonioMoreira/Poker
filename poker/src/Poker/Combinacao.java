package Poker;

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
	
	/**
	 * Calcula a frequencia de uma carta na mesa a partir do naipe e valor.
	 * @param mesa
	 * @param carta
	 * @return A frequência da carta pelo naipe e valor.
	 */
	private int pegaFrequenciaNaipeValor(Carta[] mesa,Carta carta){
		int frequencia = 0;
		for(int i = 0; i < 5 ; i++){
			if(carta.getNaipe() == mesa[i].getNaipe() && carta.getValorCarta() == mesa[i].getValorCarta()) frequencia++;
		}
		return frequencia;
	}
	
	/**
	 * Monta um vetor de frequencias pelo valor da cartas considerando naipe.
	 * @param mesa
	 * @return Vetor de frequencias de 5 posições.
	 */
	private int[] vecFrequenciaNaipeValor(Carta[] mesa){
		int f[] = {0,0,0,0,0};
		for(int i = 0 ; i < 5 ; i++) f[i] = pegaFrequenciaNaipeValor(mesa,mesa[i]);
		return f;
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
	 * Calcula a frequencia de uma carta na mesa a partir do naipe ignorando o valor.
	 * @param mesa
	 * @param carta
	 * @return A frequência da carta pelo valor.
	 */
	private int pegaFrequenciaNaipe(Carta[] mesa,Carta carta){
		int frequencia = 0;
		for(int i = 0; i < 5 ; i++){
			if(carta.getNaipe() == mesa[i].getNaipe()) frequencia++;
		}
		return frequencia;
	}
	
	/**
	 * Monta um vetor de frequencias pelo naipe da cartas ignorando o valor.
	 * @param mesa
	 * @return Vetor de frequencias de 5 posições
	 */
	private int[] vecFrequenciaNaipe(Carta[] mesa){
		int f[] = {0,0,0,0,0};
		for(int i = 0 ; i < 5 ; i++) f[i] = pegaFrequenciaNaipe(mesa,mesa[i]);
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
	
	/**
	 * Função que verifica se houve full,par,trinca ou Quadra
	 * @param f
	 * @return 0 -> par, 1 -> full, 2 -> trinca, 3 -> Quadra e -1 se não ocorreu nenhuma das citadas 
	 */
	private int checaFullParTrincaQuadra(int[] f,Carta[] mesa){
		int[] par = new int[2];
		int p = 0,t = 0,q = 0;
		
		for(int i = 0; i < 5 ; i++){
			if(f[i] == 2 && p <= 1) par[p++] = i;
			if(f[i] == 3) t = 1;
			if(f[i] == 4) q = 1;			
		}
		
		System.out.println(mesa[par[0]].getValorCarta() + " tchau "+ mesa[par[1]].getValorCarta());
		
		/* Dois pares */
		if(p == 2 && mesa[par[0]].getValorCarta() != mesa[par[1]].getValorCarta()){
			System.out.println("É 2 par");
			return 0;
		}
		/* Full House */
		if(t == 1 && p == 1) return 1;
		/* Trinca */
		if(t == 1 && p != 1) return 2;
		/* Quadra */
		if(q == 1) return 3;
		
		/* Nada */
		return -1;
		
	}
	
	/**
	 * Checa as possibilidades de (ROYAL)Straight(FLUSH)
	 * @param fn
	 * @param fnv
	 * @param mesa
	 * @return 0 -> RSF, 1 -> SF, 2 -> F, 3 -> S ou -1 caso nao de nada.
	 */
	private int checaStraightFlushRoyal(int[] fn, int[] fnv,Carta[] mesa){
		/* Todos os naipes iguais */
		if(fn[0] == 5){
			/* Houve sequencia */
			if(sequencia(mesa)){
				/* Royal straight flush */ 
				if(mesa[0].getValorCarta() == 8 && mesa[1].getValorCarta() == 9 && mesa[2].getValorCarta() == 10 && mesa[3].getValorCarta() == 11
						&& mesa[4].getValorCarta() == 12) return 0;
				/* Straight flush */
				return 1;
			}else{
				/* Flush */
				return 2;
			}
		}
		
		/* Houve só sequencia então straight */
		if(sequencia(mesa)) return 3;
		
		/* Nada */
		return -1;
		
	}
	
	/**
	 * Verifica se houve uma sequencia na mesa.
	 * @param mesa
	 * @return true se houve sequencia caso contrario false.
	 */
	private boolean sequencia(Carta[] mesa) {
		/* Ordenar cartas */
		bubbleSort(mesa);
		
		if((mesa[0].getValorCarta() + 1) == mesa[1].getValorCarta() && (mesa[1].getValorCarta() + 1) == mesa[2].getValorCarta()
				&& (mesa[2].getValorCarta() + 1) == mesa[3].getValorCarta() && (mesa[3].getValorCarta() + 1) == mesa[4].getValorCarta()) return true;
		
		return false;
	}

	/**
	 * Funcão que checa qual combinação ocorreu e retorna o respectivo premio.
	 * @param mesa
	 * @return Retorna o respectivo premio dada a combinação ou retorna -Valor da aposta.
	 */
	public int checkCombination(Carta[] mesa){
		int fv[],fn[],fnv[];
		fv = vecFrequenciaValor(mesa);
		fn = vecFrequenciaNaipe(mesa);
		fnv = vecFrequenciaNaipeValor(mesa);
		
		
		
		switch(checaFullParTrincaQuadra(fv, mesa)){
			case -1:
				/* Nada */
				System.out.println("Você não fez nenhuma combinação");
				break;
				
			case 0: /* Dois pares */
				System.out.println("Você formou dois pares");
				return this.valor;
				
			case 1: /* Full House */
				System.out.println("Você fez um full house");
				return 20*this.valor;
				
			case 2: /* Trinca */
				System.out.println("Você formou uma trinca");
				return 2*this.valor;
			
			case 3: /* Quadra */
				System.out.println("Você fez uma quadra");
				return 4*this.valor;
		}
		
		switch(checaStraightFlushRoyal(fn,fnv, mesa)){
			case -1:
				/* Nada */
				break;
				
			case 0: /* RSF */
				System.out.println("Você fez um royal straight flush ");
				return 200*this.valor;
				
			case 1: /* SF */
				System.out.println("Você fez um straigh flush");
				return 100*this.valor;
				
			case 2: /* Flush */
				System.out.println("Você fez um flush ");
				return 10*this.valor;
			
			case 3: /* Straight */
				System.out.println("Você fez um straight ");
				return 5*this.valor;
		}
		
		/* Nenhuma combinação */
		return 0;
	}
	
}
