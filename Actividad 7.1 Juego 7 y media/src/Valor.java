
/**
 * @author Makarov
 *Esta es una clase de tipo enumerado que contiene  el valor de las cartas y los puntos que tiene cada una en el juego.
 */
public enum Valor {
	 UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6),SIETE(7), SOTA(0.5), CABABALLO(0.5), REY(0.5);
	 
	 private double puntos;
	
	/**
	 * Método constructor con parámetro. Este método se deja privado. Se crea para el correcto funcionamiento de la clase
	 * pero no se podrá utilizar, para la creación de un objeto de la clase Valor se utlizan otras funciones de la clase enumerado.
	 * @param puntos
	 * 
	 */
		private Valor (double puntos) {
			this.puntos = puntos;
		}
	
	/**
	 * Método con el cual se obtendrán los puntos que tiene una carta.
	 * @return .- Número decimal.
	 */
	public double getPuntos() {
		return this.puntos;
	}
	
}
