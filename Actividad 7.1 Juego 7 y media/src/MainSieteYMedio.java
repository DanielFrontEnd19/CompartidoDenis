import java.util.Scanner;

/**
 * @author Makarov
 * Clase principal del juego 7 y medio. En esta clase se crearan unicamente los objetos de la clase jugador.
 * 
 */
/*
 * Se actualiza el comentario desde github para descargar los cambios a eclipse.
 */
public class MainSieteYMedio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int nJugadores = 0; //variable que guarda el numero de jugadores
		int turnos = 1; //variable que se utiliza en el turno de cada jugador
		boolean swJugadores = false; //variable que indica si quedan jugadores activos
		int i,j; //variables auxiliares
		int cartasRestantes = 0; //cartas restantes en la baraja
		double jMP = 0; //variable para guardar los puntos del jugador que mas tiene
		double probabilidadB = 0; //variable que guarda el numero de cartas con las que la banca pierde
		double puntosGanador = 0; //variable que almacenara los puntos que tienen los ganadores
		String otraCarta;// variable para guardar la respuesta de si un jugador quiere carta
		
		System.out.println("!!!EMPIEZA EL JUEGO!!!");
		System.out.println();
		
		System.out.println("Introduce el numero de jugadores (como maximo 5):");
		nJugadores = sc.nextInt() + 1;
		
		while (nJugadores > 6 || nJugadores < 0) {
			System.out.println("Respuesta incorrecta, vuelve a introducir el numero de jugadores:");
			nJugadores = sc.nextInt() + 1;
		}
		
		Jugador jugadores [] = new Jugador [nJugadores];
		
		/*
		 * Creamos los objetos Jugador
		 * El primero ser'a la banca y es con el que se crea la baraja, el resto de jugadores copian el objeto,
		 * de esta manera la baraja es la misma para todos. (se realiza asi por las reglas de la practica de crear solo objetos jugador en el Main)
		 */
		for (i = 0; i < nJugadores; i++) {
			
			if (i == 0) {
				jugadores[i] = new Jugador();
				jugadores[i].newBaraja();
				jugadores[i].cogeCarta();
			}
			
			jugadores[i] = new Jugador();
			jugadores[i].setBaraja(jugadores[0].getBaraja());
			jugadores[i].cogeCarta();
		}
		
		
		/*
		 * Se reparte una carta a cada jugador y se muestran por pantalla junto con los puntos que tienen actualmente.
		 */
		for (j = 0; j < nJugadores; j++) {
			
		if (j == 0) {
			System.out.println("Banca: ");
		}
		else{
			System.out.println("Jugador " + j);
		}
			for (i = 0; jugadores[j].getCartas()[i] != null; i++) {
				
				if (jugadores[j].getCartas() != null) {
					System.out.println(jugadores[j].getCartas()[i]);
				}
				else break;	
			}
			System.out.println("Total de puntos: " + jugadores[j].getPuntos());
			System.out.println();
			
			
		}
		
		/*
		 * Se empieza con el turno de cada jugador
		 */
		while (turnos < nJugadores) {
			
			System.out.println("Turno del jugador " + turnos);
			
			//Enseñamos la carta del jugador en concreto
			for (i = 0; jugadores[turnos].getCartas()[i] != null; i++) {
				
				if (jugadores[turnos].getCartas() != null) {
					System.out.println(jugadores[turnos].getCartas()[i]);
				}
				else break;	
			}
			
			
			/*
			 * Entramos en el bucle que hace pedir al jugador las cartas
			 * Si el jugador responde con ¨no¨ o bien se pasa de los 7,5 puntos, termina su turno
			 */
			otraCarta = "si";
			j = 1;
			while (otraCarta.equals("si") && jugadores[turnos].getEstado()) {
				
				System.out.println("Quieres otra carta?");
				otraCarta = sc.next();
				otraCarta = otraCarta.toLowerCase();
				
				if (otraCarta.equals("si")) {
					
					jugadores[turnos].cogeCarta();	
					System.out.println(jugadores[turnos].getCartas()[j]);
					System.out.println("Total de puntos: " + jugadores[turnos].getPuntos());
						
					/*
					 * Se comprueba si se ha pasado del limite, lo cual lo elimina poniendo su estado en false
					 */
						if (jugadores[turnos].getPuntos() > 7.5) {
							jugadores[turnos].setEstado();
						}
						
					j++;
				}
				else if (otraCarta.equals("no")) {
					break;
				}
				else {
					System.out.println("Respuesta incorrecta, responda con SI o NO.");
					otraCarta = "si";
				}
				
				if (jugadores[turnos].getEstado() == false) {
					System.out.println("Has superado la puntuacion de 7,5. Quedas eliminado.");
					break;
				}
				
			}
			
			//Si el jugador no se pasa del limite se comprueba si no es el que mas puntos tiene
			if (jugadores[turnos].getEstado() && jMP < jugadores[turnos].getPuntos()) {
				jMP = jugadores[turnos].getPuntos();
			}
			
			turnos++;
		}
		
		
		/*
		 * Comprobamos si queda algun jugador que no esté eliminado
		 */
		for (i = 1; i < nJugadores; i++) {
			if (jugadores[i].getEstado()) {
				swJugadores = true;
				break;
			}
		}
		
		/*
		 * Si quedan jugadores que no se han pasado del limite se continua con la banca, de lo contrario gana la banca automaticamente.
		 */
		if (swJugadores) {
			
			//Calculamos las probabilidades de que se pase en un primer momento.
			for (i = 0; i < 40; i++) {
				
				if (jugadores[0].getBaraja().getCartas()[i].getEstado()){
					cartasRestantes++;
					
					if ((jugadores[0].getBaraja().getCartas()[i].getValor().getPuntos() + jugadores[0].getPuntos()) > jMP) {
						probabilidadB++;
					}
				}	
			}
			
			/*
			 * A partir de aqui se decide si la banca cogerá otra carta o no.
			 */
			while (probabilidadB  < (cartasRestantes *0.5) && jugadores[0].getEstado()) {
				jugadores[0].cogeCarta();
				
				if (jugadores[0].getPuntos() > 7.5) {
					jugadores[0].setEstado();
					System.out.println("La banca pierde.");
					break;
				}
				else {
					if (jMP < jugadores[0].getPuntos()) {
						jMP = jugadores[0].getPuntos();
					}
					
					//Despues de cada carta que coja la banca se calculan las probabilidades de nuevo.
					cartasRestantes = 0;
					probabilidadB = 0;
					for (i = 0; i < 40; i++) {
						
						if (jugadores[0].getBaraja().getCartas()[i].getEstado()){
							cartasRestantes++;
							
							if ((jugadores[0].getBaraja().getCartas()[i].getValor().getPuntos() + jugadores[0].getPuntos()) > jMP) {
								probabilidadB++;
							}
						}	
					}
				}
				
			}
		
			
			/*
			 * Mostramos la mano final de la banca con los puntos totales que ha obtenido.
			 */
			System.out.println("Mano de la banca: ");
			for (i = 0; i < jugadores[0].getCartas().length; i++) {
				
				if (jugadores[0].getCartas()[i] != null) {
					System.out.println(jugadores[0].getCartas()[i]);
				}
				else break;	
			}
		System.out.println("Total puntos: " + jugadores[0].getPuntos());
	
		
		//Si la banca obitiene 7.5 gana automaticamente
		if (jugadores[0].getPuntos() == 7.5) {
			System.out.println("La banca tiene la maxima puntuacion, GANA LA BANCA. XDXDXD");
		}
		else {
			
			/*
			 * De lo contrario se comrpueba los puntos maximos que tiene un jugador activo.
			 */
			for (i = 0; i < jugadores.length; i++) {
				if (jugadores[i].getEstado() && puntosGanador < jugadores[i].getPuntos()) {
					puntosGanador = jugadores[i].getPuntos();
				}
			}
			
			/*
			 * Despues se recorre la lista de jugadores y los jugadores activos que tengan la puntuación maxima obtenida anteriormente
			 * se enseñan como ganadores
			 */
			System.out.println("La maxima puntuacion es de " + puntosGanador + " puntos. Los ganadores son: ");
			
			for (i = 0; i < jugadores.length; i++) {
				
				if (jugadores[i].getEstado() && puntosGanador == jugadores[i].getPuntos()) {
					if (i == 0) {
						System.out.println("La banca!! XD");
					}
					System.out.println("Jugador " + i);
				}
			}
			
		}
			
			
		}
		else {
			System.out.println("Todos los jugadores han sido eliminados. GANA LA BANCA");
		}
		
	
		
	}

}
