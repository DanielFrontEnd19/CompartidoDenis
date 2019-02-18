
/**
 * @author denis.bogomilov
 *Esta es una clase con la que crearemos la baraja española de 40 cartas.
 *La baraja se creará desordenada.
 */

public class Baraja {

	private Carta [] cartas = new Carta[40];
	private Valor valores [] = Valor.values();
	private Palo palos [] = Palo.values();
	private int sigCarta = 0; //se guarda la posición de la siguiente carta a repartir
	
	
	
	/**
	 * Metodo constructor de baraja sin parametros
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
	
	
	
	/**
	 * Metodo el cual devuelve un array con todas las cartas de la baraja.
	 * @return .- Array de objetos carta
	 */
	public Carta [] getCartas () {
		return this.cartas;
	}
	
	/**
	 * Metodo el cual devuelve la posición en la cual se encuentra
	 * la carta siguiente que tiene que ser repartida.
	 * @return .- Número entero.
	 */
	public int getSigCarta() {
		return this.sigCarta;
	}
	
	
	/**
	 * Metodo el cual se utiliza para repartir una carta y cambia 
	 * el valor de la siguiente carta que se tiene que repartir.
	 * @param carta .- Recoge un número entero con la posición de la carta en la baraja
	 * @return .- Devuelve un objeto Carta.
	 */
	public Carta getCarta(int carta) {
		this.sigCarta = this.sigCarta +1;
		return this.cartas[carta];
		
	}
	
	
}
