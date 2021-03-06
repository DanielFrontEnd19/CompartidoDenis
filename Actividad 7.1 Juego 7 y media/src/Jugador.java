
/**
 * @author Makarov
 * Esta es la clase principal del juego, por detras de la clase Main, ya que es donde se crean todos los métodos que se podrán utilizar
 * durante el juego.
 */
public class Jugador {

	private int TAM = 14; //el numero de cartas que un jugador puede tener como maximo
	private Carta [] cartas = new Carta[TAM];
	private double puntos; //los puntos que un jugador tiene acomulados
	private boolean estado = true; //guarda el estado de un jugador, eliminado o activo.
	private static Baraja baraja; // Se crea un objeto estatico de baraja ua que ésta será la misma para todos los jugadores.
	
	
	
	
	/**
	 * Metodo constructor Jugador sin parametros.
	 * En futuras versiones podría añadirse el parámetro de nombre del jugador.
	 */
	public Jugador () {
		this.puntos = 0;
		this.estado = true;
	}
	
	
	/**
	 * Método con el que se crea una baraja nueva, se utilizará solo con el primer jugador (la banca)
	 * El resto de jugadores utilizaran la misma baraja que obtendran con el metodo setBaraja
	 */
	public void newBaraja() {
		this.baraja = new Baraja();
	}
	
	/**
	 * Metodo con el que un jugador coge la siguiente carta de la baraja.
	 */
	public void cogeCarta () {
		
		for (int i = 0; i < TAM; i++ ) {
			if (this.cartas[i] == null) {
				this.cartas[i] = baraja.getCarta(baraja.getSigCarta());
				puntos = puntos + this.cartas[i].getValor().getPuntos(); 
				this.cartas[i].setEstado();
				break;
			}
		}
		
		
	}
	
	/*
	 * Metodos get y set necesarios de los parametros
	 */
	public void setEstado () {
		this.estado = false;
	}
	
	public boolean getEstado () {
		return this.estado;
	}
	
	public double getPuntos () {
		return this.puntos;
	}
	
	public Carta [] getCartas () {
		return this.cartas;
	}
	
	public Baraja getBaraja() {
		return this.baraja;
	}
	
	
	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
}
