
/**
 * @author Makarov
 *Esta es una clase de tipo enumerado que contiene  el valor de las cartas
 */
public enum Valor {
	 UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6),SIETE(7), SOTA(0.5), CABABALLO(0.5), REY(0.5);
	 
	 private double puntos;
	
	private Valor (double puntos) {
		this.puntos = puntos;
	}
	
	public double getPuntos() {
		return this.puntos;
	}
	
	
	
	
	
	
	
}
