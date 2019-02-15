
public class Baraja {

	private Carta [] cartas = new Carta[40];
	private Valor valores [] = Valor.values();
	private Palo palos [] = Palo.values();
	private int sigCarta = 0; //se guarda la posición de la siguiente carta a repartir
	
	
	
	/**
	 * Metodo constructor sin parametros
	 */
	public Baraja () {

		//Se genera una baraja con las cartas desordenadas.
		for (int i = 0; i < 40; i++) {
			cartas[i] = new Carta (valores[(int) Math.round(Math.random() *9)], palos[(int) Math.round(Math.random() *3)]);
			
			for (int j = 0; j < i; j++) {
				if (cartas[j].compareTo(cartas[i])) {
					i = i-1;
					break;
				}
			}
				
			
		}
	}
	
	
	
	public Carta [] getCartas () {
		return this.cartas;
	}
	
	public int getSigCarta() {
		return this.sigCarta;
	}
	
	public Carta getCarta(int carta) {
		this.sigCarta = this.sigCarta +1;
		return this.cartas[carta];
		
	}
	
	
}
