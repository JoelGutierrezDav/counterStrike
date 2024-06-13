import java.util.LinkedList;

public class Equipo {
	
	    private String nombre;
	    private LinkedList<Jugador> jugadores;

	    public Equipo(String nombre, LinkedList<Jugador> jugadores) {
	        this.nombre = nombre;
	        this.jugadores = jugadores;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public LinkedList<Jugador> getJugadores() {
	        return jugadores;
	    }
	}


