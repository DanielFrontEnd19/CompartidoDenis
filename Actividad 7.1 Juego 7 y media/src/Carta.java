
/**
 * @author Makarov
 *Esta es una clase con la que crearemos las cartas de la baraja española a partir de la información que tenemos en los
 *enumerados ¨palo¨ y ¨valor¨
 */
public class Carta {

	private Valor valor;
	private Palo palo;
	private boolean estado; //variable que almacena si una carta se ha utilizado o no
	
	public Carta () {
		
	}
	
	/**
	 * Metodo constructor con parametros
	 * @param valor
	 * @param palo
	 */
	public Carta (Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
		this.estado = true;
	}
	
	public String toString () {
		String carta = "";
		carta = this.valor.name() + " DE " + this.palo.name();
		
		return carta;
	}
	
	/*
	 * Metodos get y set de los parametros de la clase.
	 */
	public boolean getEstado() {
		return this.estado;
	}
	
	//se modificará solo el estado de la carta.
	public void setEstado() {
		this.estado = false;
	}
	
	public Valor getValor() {
		return this.valor;
	}
	
	public Palo getPalo() {
		return this.palo;
	}
	
	
	
	/**
	 * Metodo para comparar dos cartas, se utiliza a la hora de crear la baraja.
	 * @param otraCarta
	 * @return
	 */
	public boolean compareTo (Carta otraCarta) {
		boolean sw = false;
		
		if (this.valor.compareTo(otraCarta.getValor()) == 0 &&  this.palo.compareTo(otraCarta.getPalo()) == 0) {
			sw = true;
		}
		return sw;
	}
	
	
}
